import React from 'react'
import ReactDOM from 'react-dom'
import { DropdownButton, MenuItem } from 'react-bootstrap'

export default class MacroDropdown extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            bypass: "false"
        }
        this.changeSelection = this.changeSelection.bind(this);
    }

    componentDidMount(){
        var cookies = document.cookie.split(/=/);
        var info = {
            "authentication": cookies[1]
        };

        console.log(JSON.stringify(info));
        $.ajax({
            type: "POST",
            url: "/macro",
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

    changeSelection(e) {
        this.setState({skipReview: e})
    }

    render() {
        return(
            <DropdownButton bsStyle='default' title="Macros" key={1}>
                <MenuItem eventKey="1">Update Schedule Start time by Run Name and Audit ID</MenuItem>
                <MenuItem eventKey="2">Delete all entries by Run Name</MenuItem>
                <MenuItem eventKey="3">Update Status Code by Run Name and Audit ID</MenuItem>
            </DropdownButton>
        )
    }
}