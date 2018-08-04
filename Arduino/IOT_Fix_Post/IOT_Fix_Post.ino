#include <Arduino.h>
#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>

#include <SocketIoClient.h>

#define USE_SERIAL Serial

ESP8266WiFiMulti WiFiMulti;
SocketIoClient webSocket;

int temperature = 0;
String stringSuhu;
char *data2;

void event(const char * payload, size_t length) {
  USE_SERIAL.printf("got message: %s\n", payload);
}

void setup() {

    HTTPClient http;
    USE_SERIAL.begin(115200);

    USE_SERIAL.setDebugOutput(true);

    USE_SERIAL.println();
    USE_SERIAL.println();
    USE_SERIAL.println();

      for(uint8_t t = 4; t > 0; t--) {
          USE_SERIAL.printf("[SETUP] BOOT WAIT %d...\n", t);
          USE_SERIAL.flush();
          delay(1000);
      }

    WiFiMulti.addAP("MEDOKAN BARU IV NO 12", "widyastuti");

    while(WiFiMulti.run() != WL_CONNECTED) {
        delay(100);
    }

//    http.begin("https://thawing-citadel-35451.herokuapp.com/");
    webSocket.begin("thawing-citadel-35451.herokuapp.com");
//    webSocket.begin("192.168.0.17",3000);
    webSocket.on("connection", event);
}

void loop() {
    temperature = analogRead(A0);
    stringSuhu = String(temperature);
    USE_SERIAL.println("Suhu: " + stringSuhu);
    webSocket.loop();
    webSocket.emit("data", stringSuhu.c_str());
    delay(2000);
}
