import React from 'react'
import ReactDOM from 'react-dom';
import { Table } from 'react-bootstrap';
import { DropdownButton } from 'react-bootstrap';
import { ButtonToolbar } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import $ from 'jquery'
import { Navigation, Router, Route, Link } from 'react-router'

export default class PeerReview extends React.Component{
    render() {
        return (
            <section className="container">
                <div className="macro">
                  <h1>Macro History</h1>
                    <div className="row">
                      <div className="col-md-2">
                          <div className="dropdown">
                              <button className="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                  Sort By
                                  <span className="caret"></span>
                              </button>
                              <ul className="dropdown-menu" aria-labelledby="dropdownMenu1">
                                  <li><a href="#">Recent</a></li>
                                  <li><a href="#">Oldest</a></li>
                                  <li role="separator" class="divider"></li>
                                  <li><a href="#">Recent - Not Reviewed</a></li>
                              </ul>
                          </div>
                      </div>
                
                
                      <table className="table table-striped table-bordered table-hover">
                        <tr>
                            <th>Macro</th>
                            <th>Creation Date</th>
                            <th>Submitter</th>
                            <th>Reviewer</th>
                        </tr>
                        
                        <tr>
                            <td params="param1:something, param2:453">Example</td>
                            <td>12/13/2016 16:16</td>
                            <td>Someone</td>
                            <td>Not reviewed yet</td>
                        </tr>
                        <tr>
                            <td params="param1:somethingElse, param2:84651">Example</td>
                            <td>12/13/2016 14:47</td>
                            <td>Someone</td>
                            <td>Someone else</td>
                        </tr>
                        <tr>
                            <td params="param1:41238, param2:Something">Example</td>
                            <td>12/13/2016 14:35</td>
                            <td>Someone</td>
                            <td>Peer Review Bypassed</td>
                        </tr>
                        <tr>
                            <td params="param1:something, param2:somethingElse">Example</td>
                            <td>12/12/2016 18:38</td>
                            <td>Someone</td>
                            <td>Someone else</td>
                        </tr>
                    </table>
                
                </div>
              </div>
            </section>
        )
    }
}