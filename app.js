const express = require('express');
const app = express();
const http = require('http');
const hbs = require('hbs');
const socketIO = require('socket.io');
const delay = require('delay');

var server = http.createServer(app);
var io = socketIO(server);

var port = process.env.PORT || 3000;

app.set('view engine','hbs');
app.use(express.static(__dirname + '/public'));

app.get("/data/:value",function(req,res){
    myValue = req.params.value;
    port_data = port;
    res.render("data.hbs",{
        data:myValue,
        port:port_data
    });
});

app.get("/",function(req,res){
    res.render("index.hbs");
});

io.on('connection',function(socket){

    console.log("A user connected");

    socket.on('data', function(data){
        mySuhu = data;
        console.log("Suhu: " + mySuhu);
        io.emit("data",{
            suhu:mySuhu,
        })

      });

      socket.on('analog', function(analog){
        myAnalog = analog;
        console.log("Analog: " + myAnalog);

        io.emit("analog",{
            analog:myAnalog
        })

      });

});


server.listen(port,function(){
    console.log("Server is running");
    console.log("At " + port);
});