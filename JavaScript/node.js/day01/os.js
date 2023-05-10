var os = require('os') //查看计算机信息
console.log('Tmpdir: ' + os.tmpdir());
console.log('Endianness: ' + os.endianness());
console.log('hostname: ' + os.hostname());
console.log('Type: ' + os.type());
console.log('Platform: ' + os.platform());
console.log('Arch: ' + os.arch());
console.log('Release: ' + os.release());
console.log('Uptime: ' + os.uptime());
console.log('Loadavg: ' + os.loadavg());
console.log('Totalmem: ' + os.totalmem());
console.log('Freemem: ' + os.freemem());
console.log('Cpus: ' + JSON.stringify(os.cpus()));
console.log('NetworkInterfaces: ' + JSON.stringify(os.networkInterfaces()));