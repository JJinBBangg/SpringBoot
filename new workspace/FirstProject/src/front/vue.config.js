const path = require('path')
module.exports = {
	devServer : {
		proxy : {
			'/api' : {
				target : 'http://localhost:8085',
				ws : true,
				changeOrigin : true
			},
		}
	}
}



/*module.exports = defineConfig({
  transpileDependencies: true
})*/