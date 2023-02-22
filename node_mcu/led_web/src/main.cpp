/* Create a WiFi access point and provide a web server on it. */
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <EEPROM.h>
#include <ESP8266HTTPClient.h>

#ifndef APSSID
// #define APSSID "ESPap"
// #define APPSK  "thereisnospoon"
#define APSSID "1011001"
#define APPSK  "dr0wss@p"
#endif

/* Set these to your desired credentials. */
const char *ssid = APSSID;
const char *password = APPSK;
const int led = LED_BUILTIN;
ESP8266WebServer server(80);
String st;
String content;
String esid="";
String epass = "";
int statusCode;
bool haveExtIp = false;
uint8_t retries=0;
uint8_t timer = 0;
uint8_t LED_Pin = D4;
/* Just a little test message.  Go to http://192.168.4.1 in a web browser
   connected to this access point to see it.
*/
void handleScan() {
   
      //setupAP();
      IPAddress ip = WiFi.softAPIP();
      String ipStr = String(ip[0]) + '.' + String(ip[1]) + '.' + String(ip[2]) + '.' + String(ip[3]);
      content = "<!DOCTYPE HTML>\r\n<html>go back and refresh/reload your page. " + ipStr;
      server.send(200, "text/html", content);

}
void handleRoot2() {
   
      content = "<!DOCTYPE HTML>\r\n<html>Add features like change wifi SSID and Password, control switch through wifi";
      server.send(200, "text/html", content);

}

void handleNotFound() {
  digitalWrite(led, 1);
  String message = "File Not Found\n\n";
  message += "URI: ";
  message += server.uri();
  message += "\nMethod: ";
  message += (server.method() == HTTP_GET) ? "GET" : "POST";
  message += "\nArguments: ";
  message += server.args();
  message += "\n";
  for (uint8_t i = 0; i < server.args(); i++) {
    message += " " + server.argName(i) + ": " + server.arg(i) + "\n";
  }
  server.send(404, "text/plain", message);
  digitalWrite(led, 0);
}


void handleForm() {
  if (server.method() != HTTP_POST) {
    server.send(405, "text/plain", "Method Not Allowed");
  } else {
      String qsid = server.arg("ssid");
      String qpass = server.arg("pass");
      if (qsid.length() > 0 && qpass.length() > 0) {
        Serial.println("clearing eeprom");
        for (int i = 0; i < 96; ++i) {
          EEPROM.write(i, 0);
        }
        Serial.println(qsid);
        Serial.println("");
        Serial.println(qpass);
        Serial.println("");
        Serial.println("writing eeprom ssid:");
        for ( int i = 0; i < (int) qsid.length(); ++i)
        {
          EEPROM.write(i, qsid[i]);
          Serial.print("Wrote: ");
          Serial.println(qsid[i]);
        }
        Serial.println("writing eeprom pass:");
        for (int i = 0; i < (int)qpass.length(); ++i)
        {
          EEPROM.write(32 + i, qpass[i]);
          Serial.print("Wrote: ");
          Serial.println(qpass[i]);
        }
        EEPROM.commit();
        content = "{\"Success\"saved to eeprom... reset to boot into new wifi}";
        statusCode = 200;
        ESP.restart();
      } else {
        content = "{Error Couldn\'t Connect to AP. Try Again}";
        statusCode = 404;
        Serial.println("Sending 404");
      }  
  }
}
bool testWifi(void)
{
  int c = 0;
  //Serial.println("Waiting for Wifi to connect");
  while ( c < 20 ) {
    if (WiFi.status() == WL_CONNECTED)
    {
      return true;
    }
    delay(500);
    Serial.print("*");
    c++;
  }
  Serial.println("");
  Serial.println("Connection timed out, opening AP");
  return false;
}

void handleRoot() {
  //CHECK: This code blocks webpage..needs asynchronous mechanism to scan network.
  Serial.println("* Scan Networks *");
  int numSsid = WiFi.scanNetworks();
  while(numSsid <= 0){
    Serial.println("* Scan Networks Again*");
    delay(1000);
    numSsid = WiFi.scanNetworks();
  }
  
  // print the list of networks seen:
  Serial.print("number of available networks:");
  Serial.println(numSsid);

      content = "<!DOCTYPE HTML>\r\n<html>Welcome to Wifi Credentials Update page";
      content += "<form action=\"/scan\" method=\"POST\"><input type=\"submit\" value=\"scan\"></form>";
      content += "<p>";
      content += "</p><form action=\"/setting\" method=\"POST\"><label>SSID: </label>";
      content += "<select name='ssid' id='SSIDs'>";
     for (int thisNet = 0; thisNet < numSsid; thisNet++) {
           content += "<option value='" + WiFi.SSID(thisNet) + "'>" + WiFi.SSID(thisNet)+"</option>";
        }      
      content += "<input name='pass' length=64><input type='submit'></form>";
      content += "</html>";
      server.send(200, "text/html", content);
}


void createWebServer2()
{
  Serial.println("Web Server while wifi is connected....");
  /* You can remove the password parameter if you want the AP to be open. */
  server.on("/", handleRoot2);
  //server.on("/scan", handleScan);
  //server.on("/setting", handleForm);
  server.onNotFound(handleNotFound);
  server.begin();
  Serial.println("HTTP server started");
  
}

void createWebServer()
{
  Serial.println("Configuring access point...");
  /* You can remove the password parameter if you want the AP to be open. */
  WiFi.softAP(ssid, password);
  IPAddress myIP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(myIP);
  server.on("/", handleRoot);
  server.on("/scan", handleScan);
  server.on("/setting", handleForm);
  server.onNotFound(handleNotFound);
  server.begin();
  Serial.println("HTTP server started");
  
}
void setup() {
  pinMode(LED_Pin, OUTPUT);   // Initialize the LED pin as an output
  delay(1000);
  // Serial.begin(115200);
  Serial.begin(9600);
  Serial.println();

  //Serial.println("Disconnecting current wifi connection");
  //WiFi.disconnect();
  delay(1000);
  EEPROM.begin(512); //Initialasing EEPROM
  delay(10);
 // pinMode(15, INPUT);
  Serial.println();
  Serial.println();
  Serial.println("Startup");
  //---------------------------------------- Read eeprom for ssid and pass
  Serial.println("Reading EEPROM ssid");
  for (int i = 0; i < 32; ++i)
  {
    esid += char(EEPROM.read(i));
  }
  Serial.println();
  Serial.print("SSID: ");
  Serial.println(esid);
  Serial.println("Reading EEPROM pass");
  for (int i = 32; i < 96; ++i)
  {
    epass += char(EEPROM.read(i));
  }
  Serial.print("PASS: ");
  Serial.println(epass);
  WiFi.begin(esid.c_str(), epass.c_str());
  
  while(WiFi.status()!=WL_CONNECTED && retries<20)
  {
    Serial.print(".");
    retries++;
    delay(1000);
  }
 
  Serial.println();
  //Inform the user whether the timeout has occured, or the ESP8266 is connected to the internet
  if(retries>=20)//Timeout has occured
  {
    Serial.print("Unable to Connect to ");
    Serial.println(ssid);
  }
   
  if(WiFi.status()==WL_CONNECTED)//WiFi has succesfully Connected
  {
    Serial.print("Successfully connected to ");
    Serial.println(ssid);
    Serial.print("IP Address: ");
    Serial.println(WiFi.localIP());
    // GetExternalIP();
  }
  createWebServer2(); //webserver when connected to WIFI
}
void GetExternalIP()
{
  WiFiClient client;
  if (!client.connect("api.ipify.org", 80)) {
    Serial.println("Failed to connect with 'api.ipify.org' !");
  }
  else {
    int timeout = millis() + 5000;
    client.print("GET /?format=json HTTP/1.1\r\nHost: api.ipify.org\r\n\r\n");
    while (client.available() == 0) {
      if (timeout - millis() < 0) {
        Serial.println(">>> Client Timeout !");
        client.stop();
        return;
      }
    }
    int size;
    while ((size = client.available()) > 0) {
      uint8_t* msg = (uint8_t*)malloc(size);
      size = client.read(msg, size);
      Serial.write(msg, size);
      free(msg);
      haveExtIp = true;
    }
  }
}
void loop() {
   if ((WiFi.status() == WL_CONNECTED))
  {
      server.handleClient();
/*      if(!haveExtIp)
      {
        GetExternalIP();
     }
*/ 
  
     //code to fetch status data
    if(timer > 100){
      WiFiClient client;
      HTTPClient http;

      String serverPath = "http://pandeyananta.com.np";
      
      // Your Domain name with URL path or IP address with path
      http.begin(client, serverPath.c_str());
      
      // Send HTTP GET request
      int httpResponseCode = http.GET();
      
      if (httpResponseCode>0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
        String payload = http.getString();
        Serial.println(payload);
        if(payload == "0")
          digitalWrite(LED_Pin, LOW); // Turn the LED on
          else if (payload == "1")
          digitalWrite(LED_Pin, HIGH); // Turn the LED OFF
          else
          Serial.println("Unrecognized payload");
      }
      else {
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
      }
      // Free resources
      http.end();
      timer = 0;
    } else{
      timer++;
    }
  // code to fetch status data
  /*
  if (testWifi() && (digitalRead(15) != 1))
  {
    Serial.println(" connection status positive");
    return;
  }  */ 
  }else
  {
          if(!testWifi()){
            Serial.println("Connection Status Negative / D15 HIGH");
            Serial.println("Turning the HotSpot On to change password of wifi");
            //launchWeb();
            // setupAP();// Setup HotSpot
            WiFi.disconnect();
            createWebServer();    
          }
          
          Serial.println();
          Serial.println("Waiting.");
          while ((WiFi.status() != WL_CONNECTED))
          {
            //Serial.print(".");
            delay(100);
            server.handleClient();
          }
          delay(1000);
  
  }
}