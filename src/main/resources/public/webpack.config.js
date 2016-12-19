var webpack = require('webpack');
var path = require('path');

var BUILD_DIR = path.resolve(__dirname, './js');
var APP_DIR = path.resolve(__dirname, './');

var config = {
	entry: './runMacro.jsx',
	output: {
		path: BUILD_DIR,
		filename: 'runMacroCompiled.js'
	},
	entry: './login.jsx',
	output: {
		path: BUILD_DIR,
		filename: 'loginCompiled.js'
	},
	module : {
		loaders : [
			{
				test : /\.jsx?/,
				include : APP_DIR,
				loader : 'babel'
			}
		]
	}
};

module.exports = config;