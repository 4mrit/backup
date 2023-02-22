// "http://api.thingspeak.com/update?api_key=KUC87RKGO71YP26C&field1=
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266HTTPClient.h>
#include <MPU9050.h>

void connect_wifi();

WiFiClient client;
HTTPClient http;

  int field = 1;
  char* operation="update";
  char* api_key = "KUC87RKGO71YP26C";
  char* server_name = "http://api.thingspeak.com/";

void setup() {
  Serial.begin(9600);
  connect_wifi();

}
void loop() {
  int data = random(1,100);

  char request[100];
  snprintf(request, 100, "%s%s?api_key=%s&field%d=%d", server_name,operation,api_key,field,data);
  Serial.println(request);

  http.begin(client,request);
  Serial.println();
  Serial.println(data);
  Serial.print("code : ");
  Serial.println(http.GET());

  String payload = http.getString();
  Serial.println(payload);

  delay(16000);
}

void connect_wifi()
{
  WiFi.mode(WIFI_STA);
  WiFi.begin("1011001","dr0wss@p");
  while(!WiFi.isConnected())
  {
    Serial.print(".");
    delay(200);
  }
  Serial.println("connected!!");
}