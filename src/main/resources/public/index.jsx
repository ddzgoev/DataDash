import React from 'react'
import { render } from 'react-dom'
import App from './js/app.jsx'
import { Router, Route, hashHistory, IndexRoute } from 'react-router'
import Login from './js/Login.jsx'
import RunMacro from './js/RunMacro.jsx'
import Home from './js/Home.jsx'
import PeerReview from './js/PeerReview.jsx'
import History from './js/History.jsx'
import Failures from './js/Failures.jsx'

render((
    <Router history={hashHistory}>
        <Route path="/login" component={Login}/>
        <Route path="/" component={App}>
            {/* make them children of `App` */}
            <Route path="/home" component={Home}/>
            <Route path="/runMacro" component={RunMacro}/>
            <Route path="/peerReview" component={PeerReview}/>
            <Route path="/history" component={History}/>
            <Route path="/failures" component={Failures}/>
        </Route>
    </Router>
), document.getElementById('app'))