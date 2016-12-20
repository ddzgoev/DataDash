import React from 'react'
import ReactDOM from 'react-dom'

export default class RunMacro extends React.Component{
    constructor(props){
        super(props)
        this.submit = this.submit.bind(this);
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
                console.log(msg);
                if(msg.status == "SUCCESS"){
                    this.setState({auth: msg.authentication})
                    window.location = '/index.html';
                    this.setState({hasAuth: true});
                } else {
                    ShowFailureAtDOM('login');
                }
            }.bind(this)     
        });
    }

    render() {
        return(
            <section className="container">
                <div className="macro">
                    <h1>Run Macro</h1>
                    <div className="row">
                        <div className="col-md-2">
                            <div id="classdropdown"><script src="js/compiled.js" type="text/javascript"></script></div>
                            <div className="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    Specific Macros
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Update Schedule Start time by Run Name and Audit ID</a></li>
                                    <li><a href="#">Delete all entries by Run Name</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Update Status Code by Run Name and Audit ID </a></li>
                                    <li><a href="#">Update Valuation End Date by Run Name and Audit ID</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Update Valuation Start time by Run Name and Audit ID</a></li>
                                    <li><a href="#">Update SLA Date and Time by Audit ID</a></li>
                                </ul>
                            </div>
                        </div>

                        <form enctype='application/json' method="post" action="/macro">
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="input-group">
                                        <label for="run_name">Run Name</label>
                                        <input type="text" name="run_name" value="" placeholder="Run Name" id="run_name"/><br />
                                        <label for="audit_id">Audit ID</label>
                                        <input type="text" name="audit_id" value="" placeholder="Audit ID" id="audit_id"/><br />
                                        <label for="scheduled_start">Scheduled Start Time</label>
                                        <input type="text" name="scheduled_start" value="" placeholder="Schedule Start Time" id="scheduled_start"/><br />
                                        <label for="valuation_end">Valuation End Time</label>
                                        <input type="text" name="valuation_end" value="" placeholder="Valuation End Time" id="valuation_end"/><br />
                                        <label for="driver_step_id">Driver Step ID</label>
                                        <input type="text" name="driver_step_id" value="" placeholder="Driver Step ID" id="driver_step_id"/><br />
                                        <label for="driver_step_detail_id">Driver Step Detail ID</label>
                                        <input type="text" name="driver_step_detail_id" value="" placeholder="Driver Step Detail ID" id="driver_step_detail_id"/><br />
                                        <label for="description">Description</label>
                                        <input type="text" name="description" id="description" value=""/><textarea rows="5" cols="15" id="description" maxlength="255"></textarea>
                                    </div>
                                </div>
                                <label for="valuation_end">Valuation End Time</label>
                                <input type="text" name="valuation_end" value="" placeholder="Valuation End Time" id="valuation_end"/><br /> 
                                <label for="sla_date">SLA Date</label>
                                <input type="text" name="sla_date" value="" placeholder="SLA Date" id="sla_date"/><br />
                                <label for="sla_time">SLA Time</label>
                                <input type="text" name="sla_time" value="" placeholder="SLA Time" id="sla_time"/><br />
                                <label for="group_number">Group Number</label>
                                <input type="text" name="group_number" value="" placeholder="Group Number" id="group_number"/><br />
                                <label for="active_step_indicator">Active Step Indicator</label>
                                <input type="text" name="active_step_indicator" value="" placeholder="Active Step Indicator" id="active_step_indicator"/><br />
                                <div class="input-group">
                                    <div class="input-group-button">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Status <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Pending</a></li>
                                            <li><a href="#">Running</a></li>
                                            <li><a href="#">Successful</a></li>
                                            <li><a href="#">Failure</a></li>
                                        </ul>
                                    </div>
                                    <input type="text" class="form-control" sytle="width:50px;" size="1"/><br />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <p class="submit"><button type="submit" name="commit" value="Login" class="btn btn-primary btn-lg" onClick={this.submit}>Submit</button></p>
                                    <p class="remember_me">
                                        <label>
                                            <input type="checkbox" name="bypass_peer_review" id="bypass_peer_review"/>
                                            Bypass Peer Review
                                        </label>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        )
    }
}