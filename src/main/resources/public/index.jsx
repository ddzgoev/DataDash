import React from 'react'
import { render } from 'react-dom'
import App from './js/app.jsx'
import { Router, Route, hashHistory } from 'react-router'
import Login from './js/Login.jsx'
import RunMacro from './js/RunMacro.jsx'

render((
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            {/* make them children of `App` */}
            <Route path="/runMacro" component={RunMacro}/>
        </Route>
        <Route path="/login" component={Login}/>
    </Router>
), document.getElementById('app'))