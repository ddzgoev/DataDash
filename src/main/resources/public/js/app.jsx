import React from 'react'
import { Link } from 'react-router'
import NavLink from './NavLink.jsx'
import { Navbar, Nav, NavItem, Button, Glyphicon } from 'react-bootstrap'
import Login from './Login.jsx'

const navbarInstance = (
    <Navbar collapseOnSelect>
        <Navbar.Header>
            <Navbar.Brand>
                <NavLink to="/home">LM</NavLink>
            </Navbar.Brand>
            <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
            <Nav>
                <NavItem eventKey={1} href="#"><Link to="/runMacro">Run Macro</Link></NavItem>
                <NavItem eventKey={2} href="#"><NavLink to="/peerReview">Peer Review</NavLink></NavItem>     
                <NavItem eventKey={3} href="#"><NavLink to="/">Macro History</NavLink></NavItem>
                <NavItem eventKey={4} href="#"><NavLink to="/home">Failures</NavLink></NavItem>
                <NavItem eventKey={5} href="#"><NavLink to="/home">View Run Names</NavLink></NavItem>
                <NavItem eventKey={6} href="#"><NavLink to="/home">Historical Trending</NavLink></NavItem>
                <NavItem eventKey={7} href="#"><NavLink to="/home">Dependencies</NavLink></NavItem>
                <NavItem eventKey={7} href="#"><NavLink to="/home">Past Step Average</NavLink></NavItem>

            </Nav>
        </Navbar.Collapse>
    </Navbar>
);

export default React.createClass({
    render() {
        return (
            <div>
                <div>
                    <a href="homepage.html">
                        <img class="resize" src="liberty.jpeg" width="30%"/>
                    </a>
                    <Button><Glyphicon glyph="glyphicon glyphicon-log-out"></Glyphicon> Logout</Button>


                </div>
                {navbarInstance}

                {/* add this */}
                {this.props.children}
            </div>
        )
    }
});
