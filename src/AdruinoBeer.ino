#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Servo.h>

Servo servo;
const char* ssid = "hakaTUM-5G";
const char* password = "hackatum";
 
void setup () {
 
  Serial.begin(115200);
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
 
    delay(1000);
    Serial.print("Connecting..");
    
  }
  servo.attach(D0);
  servo.write(0);
  delay(2000);
}
 
void loop() {

  servo.write(180);
  delay(1000);
  servo.write(0);
  delay(1000);
 
 /* if (WiFi.status() == WL_CONNECTED) { //Check WiFi connection status
 
    HTTPClient http;  //Declare an object of class HTTPClient
 
    http.begin("http://jsonplaceholder.typicode.com/users/1");  //Specify request destination
    int httpCode = http.GET();                                                                  //Send the request
 
    if (httpCode > 0) { //Check the returning code
 
      String payload = http.getString();   //Get the request response payload
      Serial.println(payload);                     //Print the response payload
 
    }
 
    http.end();   //Close connection
 
  }
 
  delay(30000);    //Send a request every 30 seconds
 */
}
