const express = require('express');
const app = express();
const http = require('http');
const hbs = require('hbs');
const socketIO = require('socket.io');

var server = http.createServer(app);
var io = socketIO(server);

app.set('view engine','hbs');
app.use(express.static(__dirname + '/public'));

app.get("/:value",function(req,res){
    myValue = req.params.value;
    res.render("data.hbs",{
        data:myValue
    });
})

io.on('connection',function(socket){
    console.log("A user connected");
    socket.on('data', function(data){
        console.log("Suhu: " + data);
      });
})

server.listen(process.env.PORT || 3000,function(){
    console.log("Server is running");
    console.log("At" + process.env.PORT);
})