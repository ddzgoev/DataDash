import React from 'react'
import ReactDOM from 'react-dom'
import { DropdownButton, MenuItem } from 'react-bootstrap'
import MacroDropdown from './MacroDropdown.jsx'

export default class RunMacro extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            bypass: "false"
        }
        this.submit = this.submit.bind(this);
        this.changeSelection = this.changeSelection.bind(this);
    }

    submit(){
        var cookies = document.cookie.split(/=/);
        var info = {
            "authentication": cookies[1],
            "macroType": "DRIVER_SCHEDULE_DELETE_BY_RUN_NAME",
            "parameters": ["test"],
            "skipReview": "true"
        };


        console.log(JSON.stringify(info));
        var inf = ''
        $.ajax({
            type: "POST",
            url: "/macro/runMacro",
            data: JSON.stringify(info),
            dataType: 'json',
            success:function(msg) {
                if(msg.status == "AUTHENTICATION_ERROR"){
                    console.log(msg);
                    alert("Your macro has been submitted");
                } else {
                    console.log(msg);
                    alert("Your macro has been submitted");
                }
            },
            error:function(){
                window.location = '/index.html#/runMacro';
                alert("Your macro has been submitted");
                console.log('error');
            }
        });
    }

    changeSelection(e) {
        this.setState({skipReview: e})
    }

    render() {
        return(
            <section className="container">
                <div className="macro">
                    <h1>Run Macro</h1>
                    <div className="row">
                        <div className="col-md-2">
                            <MacroDropdown/>
                        </div>

                        <div className="row">
                            <div className="col-md-5">
                                <div className="input-group">
                                    <label for="run_name">Run Name</label>
                                    <input type="text" name="run_name" placeholder="Run Name" id="run_name"/><br />
                                    <label for="audit_id">Audit ID</label>
                                    <input type="text" name="audit_id" placeholder="Audit ID" id="audit_id"/><br />
                                    <label for="scheduled_start">Scheduled Start Time</label>
                                    <input type="text" name="scheduled_start" placeholder="Schedule Start Time" id="scheduled_start"/><br />
                                    <label for="valuation_end">Valuation End Time</label>
                                    <input type="text" name="valuation_end" placeholder="Valuation End Time" id="valuation_end"/><br />
                                    <label for="driver_step_id">Driver Step ID</label>
                                    <input type="text" name="driver_step_id" placeholder="Driver Step ID" id="driver_step_id"/><br />
                                    <label for="driver_step_detail_id">Driver Step Detail ID</label>
                                    <input type="text" name="driver_step_detail_id" placeholder="Driver Step Detail ID" id="driver_step_detail_id"/><br />
                                    <label for="description">Description</label>
                                    <input type="text" name="description" id="description" maxLength="255" placeholder="Description"/>
                                </div>
                            </div>
                            <label for="valuation_end">Valuation End Time</label>
                            <input type="text" name="valuation_end" placeholder="Valuation End Time" id="valuation_end"/><br /> 
                            <label for="sla_date">SLA Date</label>
                            <input type="text" name="sla_date" placeholder="SLA Date" id="sla_date"/><br />
                            <label for="sla_time">SLA Time</label>
                            <input type="text" name="sla_time" placeholder="SLA Time" id="sla_time"/><br />
                            <label for="group_number">Group Number</label>
                            <input type="text" name="group_number" placeholder="Group Number" id="group_number"/><br />
                            <label for="active_step_indicator">Active Step Indicator</label>
                            <input type="text" name="active_step_indicator" placeholder="Active Step Indicator" id="active_step_indicator"/><br />
                            <label for="status">Status</label>
                            <input type="text" name="status" placeholder="Status" id="status"/><br />
                        </div>
                        <div className="row">
                            <div className="col-md-2">
                                <p className="submit"><button name="commit" value="Submit" className="btn btn-primary btn-lg" onClick={this.submit}>Submit</button></p>
                                <p className="remember_me">
                                    <label>
                                        <input type="checkbox" name="bypass_peer_review" id="bypass_peer_review" onChange={this.changeSelection}/>
                                        Bypass Peer Review
                                    </label>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        )
    }
}