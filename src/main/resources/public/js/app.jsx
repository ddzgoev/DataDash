import React from 'react'
import { Link } from 'react-router'
import NavLink from './NavLink.jsx'
import { Navbar, Nav, NavItem } from 'react-bootstrap'

const navbarInstance = (
  <Navbar inverse collapseOnSelect>
    <Navbar.Header>
      <Navbar.Brand>
        <NavLink to="/home">LM</NavLink>
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
      <Nav>
        <NavItem eventKey={1} href="#">Link</NavItem>
        <NavItem eventKey={2} href="#">Link</NavItem>
      </Nav>
      <Nav pullRight>
        <NavItem eventKey={1} href="#">Link Right</NavItem>
        <NavItem eventKey={2} href="#">Link Right</NavItem>
      </Nav>
    </Navbar.Collapse>
  </Navbar>
);

export default React.createClass({
    render() {
        return (
            <div>
            {navbarInstance}

            {/* add this */}
            {this.props.children}

            </div>
        )
    }
})