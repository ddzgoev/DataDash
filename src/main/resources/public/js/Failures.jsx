//import React from 'react'
import ReactDOM from 'react-dom'
import { DropdownButton, MenuItem } from 'react-bootstrap'
//import {Table, Column, Cell} from 'fixed-data-table';
const React = require('react');
const {Table, Column, Cell} = require('fixed-data-table');



export default React.createClass({


  render() {
    return (
    <div>
    	<section className="container">
    		<div className="macro">
                <h1>Failed Macros</h1>
                <div className="run">
                    <table className="table table-striped table-bordered">
                        <tbody>
                        <tr>
                            <th></th>
                            <th>ID</th>
                            <th>Type</th>
                            <th>Reviewed</th>
                            <th>Date Created</th>
                            <th>Date Run</th>
                            <th>Run By</th>
                            <th>Reviewed By</th>
                        </tr>
                        <tr>
                            <td>+</td>
                            <td>122343</td>
                            <td>Add</td>
                            <td>Yes</td>
                            <td>12/13/2016 16:16</td>
                            <td>12/15/2016 16:16</td>
                            <td>Someone</td>
                            <td>Someone else</td>
                        </tr>
                        <tr><td colSpan="8"><p>param1 param2 param3</p></td></tr>
                        <tr>
                            <td>+</td>
                            <td>345434</td>
                            <td>Delete</td>
                            <td>Yes</td>
                            <td>12/13/2016 14:47</td>
                            <td>12/16/2016 14:47</td>
                            <td>Someone</td>
                            <td>Someone else</td>
                        </tr>
                        <tr><td colSpan="8"><p>param1 param2 param3</p></td></tr>
                        <tr>
                            <td>+</td>
                            <td>32434</td>
                            <td>Add</td>
                            <td>Yes</td>
                            <td>12/14/2016 14:35</td>
                            <td>12/16/2016 14:35</td>
                            <td>Someone</td>
                            <td>David</td>
                        </tr>
                        <tr><td colSpan="8"><p>param1 param2 param3</p></td></tr>
                        <tr>
                            <td>+</td>
                            <td>546553</td>
                            <td>Add</td>
                            <td>No</td>
                            <td>12/12/2016 18:38</td>
                            <td>12/17/2016 18:38</td>
                            <td>Someone</td>
                            <td>Someone else</td>
                        </tr>
                        <tr><td colSpan="8"><p>param1 param2 param3</p></td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
    	</section>
    </div>
    )
  }

})