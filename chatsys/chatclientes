const net = require("net");
let clientes = [];
net.createServer( (socket) => {
const clientId = `${socket.remoteAddress}-${socket.remotePort}`; 
console.log(`Cliente ${clientId} conectado`);  //Imprimir en la consola del servidor el nuevo cliente conectado
clientes.push(socket);
console.log(`Número de clientes conectados: ${clientes.length}\n`); //Imprimir en la consola del servidor el número de clientes conectados
socket.write(`Bienvenidx cliente: ${clientId}\n`);
socket.on('data', (mensaje) => {
for (let cliente of clientes) {
if (cliente !== socket) {
cliente.write(`${clientId} ha difundido -> ${mensaje}`);
}
};
}); // Tras el evento escritura (de cualquier socket) buscar los clientes que no hayan generado el evento y escribir sobre su terminal el mensaje difundido
socket.on('end', () => { //Detección de cierre de un socket
console.log(`El cliente ${clientId} se desconectó`); //Imprimir en la consola del servidor el cliente desconectado.
let i = clientes.indexOf(socket); //Eliminar cliente desconectado de array de clientes
clientes.splice(i, 1);
});
}).listen(3000, '127.0.0.1');
console.log("Servidor para difundir mensajes entre clientes.\n");
