import React from 'react';
import ReactDOM from 'react-dom';
import { Table } from 'react-bootstrap';
import { DropdownButton } from 'react-bootstrap';
import { ButtonToolbar } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import $ from 'jquery'
import { Navigation, Router, Route, Link } from 'react-router'

export default class PeerReview extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            auth: "",
            macroName: "",
            parameters:[]
        }
    }
    
    componentDidMount(){
        var cookies = document.cookie.split(/=/);
        var info = {
            "authentication": cookies[1]
        };
        
        console.log(JSON.stringify(info));
        var inf = ''
        $.ajax({
            type: "POST",
            url: "/peerreview",
            data: JSON.stringify(info),
            dataType: 'json',
            success:function(msg) {
                console.log(msg);
                if(msg.status == "SUCCESS"){
                    console.log("succeeded")
                }
            }.bind(this)     
        });
    }

    render() {
        return(
            <section className="peerreview">
                <div className="peerreview">
                    <Table bordered condensed>
                        <thread>
                        </thread>
                        <tbody>
                            <tr>
                                <td>Macro Name</td>
                                <td>Request Date and Time</td>
                                <td>Parameters</td>
                                <td>Accept</td>
                            </tr>
                            <tr>
                                <td>Example</td>
                                <td>12/13/2016 16:16</td>
                                <td>
                                    <ul>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                    </ul>
                                </td>
                                <td><Button>Accept</Button></td>
                            </tr>
                            <tr>
                                <td>Example</td>
                                <td>12/13/2016 16:16</td>
                                <td>
                                    <ul>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                    </ul>
                                </td>
                                <td><Button>Accept</Button></td>
                            </tr>
                            <tr>
                                <td>Example</td>
                                <td>12/13/2016 16:16</td>
                                <td>
                                    <ul>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                    </ul>
                                </td>
                                <td><Button>Accept</Button></td>
                            </tr>
                            <tr>
                                <td>Example</td>
                                <td>12/13/2016 16:16</td>
                                <td>
                                    <ul>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                        <li>ParameterName: Value</li>
                                    </ul>
                                </td>
                                <td><Button>Accept</Button></td>
                            </tr>
                        </tbody>
                    </Table>
                </div>
            </section>
        )
    }
}
function ShowFailureAtDOM(id) {
    ReactDOM.unmountComponentAtNode(document.getElementById(id));
    ReactDOM.render(
        <PeerReviewFail />,
        document.getElementById(id)
    )
}

var peerReviewFail = React.createClass({
    render() {
        return (
            <h2>PeerReview FAIL...</h2>
        )
    }
});