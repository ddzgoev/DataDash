import React from 'react';
import ReactDOM from 'react-dom';
import { DropdownButton } from 'react-bootstrap';
import { ButtonToolbar } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import $ from 'jquery'

function Login(email, password) {
 var LOGIN_FLAG = 1002
 console.log(email);
 $.ajax({
  type: "POST",
  url: "/login",
  data: JSON.stringify({username:email,
  	password:password
 }),
  success: "SUCCESS",
  dataType: "json"
 });

//  var JSONData = tryParseJSON(data);
//  if (!JSONData || JSONData["status"] == "FAILURE") {
//   ShowFailureAtDOM("login");
//   return;
//  }
//
//  if(JSONData["status"] == "SUCCESS"){
//   ShowSuccessAtDome("login", "admin");
//  }
//
//  var JWTData = KJUR.jws.JWS.parse(JSONData["jwt"]);
//  if (JWTData) {
//   ShowSuccessAtDOM("login", JWTData.payloadObj.name);
//  } else {
//   ShowFailureAtDOM("login");
//  }
 };

function ShowSuccessAtDOM(id, name) {
 ReactDOM.unmountComponentAtNode(document.getElementById(id));
 ReactDOM.render(
  <LoginSuccess name={name} />,
  document.getElementById(id)
 );
};

function ShowFailureAtDOM(id) {
 ReactDOM.unmountComponentAtNode(document.getElementById(id));
 ReactDOM.render(
  <LoginFail />,
  document.getElementById(id)
 );
};

var Header = React.createClass({
 render() {
  return (
   <h1>Login to Data Dash</h1>
  )
 }
});

var LoginForm = React.createClass({
 ValidateLogin() {
  var email = this.refs.loginEmail.state.value;
  var password = this.refs.LoginPassword.state.value;
  Login(email, password);
 },
 render() {
  return (
   <div className="loginDiv">
	<Header />
	<LoginEmail ref="loginEmail"/>
	<LoginPassword ref="LoginPassword"/>
	<br></br>
	<LoginSubmit ValidateLogin={this.ValidateLogin}/>
   </div>
  )
 }
});

var LoginEmail = React.createClass({
 getInitialState() {
  return {value: null}
 },
 onChange(e) {
  this.setState({value: e.target.value});
 },
 render() {
  return (
   <div className="LoginEmailDiv">
	<input type="text" onChange={this.onChange} placeholder="Username"/>
   </div>
  )
 }
});

var LoginPassword = React.createClass({
 getInitialState() {
  return {value: null}
 },
 onChange(e) {
  this.setState({value: e.target.value});
 },
 render() {
  return (
   <div className="LoginEmailDiv">
	<input type="password" onChange={this.onChange} placeholder="Password"/>
   </div>
  )
 }
});

var LoginSubmit = React.createClass({
 onClick() {
  this.props.ValidateLogin();
 },
 render() {
  return (
   <Button bsStyle="primary" onClick={this.onClick}>Login</Button>
  )
 }
});

var LoginSuccess = React.createClass({
 render() {
  return (
   <h2>Login Success! Welcome Back, {this.props.name}</h2>
  )
 }
});

var LoginFail = React.createClass({
 render() {
  return (
   <h2>Login FAIL...</h2>
  )
 }
});


ReactDOM.render(
 <LoginForm />,
 document.getElementById('login')
);
