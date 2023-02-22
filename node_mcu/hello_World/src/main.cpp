#include <Arduino.h>

void setup() {
  Serial.begin(9600);
  pinMode(D0,OUTPUT);

}

void loop() {
  Serial.println("hello world");
  digitalWrite(D0,HIGH);
  delay(1000);
  digitalWrite(D0,LOW);
  delay(1000);

}