import React from 'react';
import ReactDOM from 'react-dom';
import { DropdownButton } from 'react-bootstrap';
import { ButtonToolbar } from 'react-bootstrap';
import { MenuItem } from 'react-bootstrap';



const BUTTONS = ['Default'];

function renderDropdownButton(title, i) {
  return (
	<DropdownButton bsStyle={title.toLowerCase()} title="Macro Class" key={i} id={`dropdown-basic-${i}`}>
	  <MenuItem eventKey="1">Driver Schedule - Update</MenuItem>
	  <MenuItem eventKey="2">Driver Schedule - Delete</MenuItem>
	  <MenuItem divider />
	  <MenuItem eventKey="3">Driver Step - Update</MenuItem>
	  <MenuItem eventKey="2">Driver Step - Delete</MenuItem>
	  <MenuItem divider />
	  <MenuItem eventKey="5">Driver Step Detail - Update</MenuItem>
	  <MenuItem eventKey="6">Driver Step Detail - Delete</MenuItem>
	</DropdownButton>
  );
}

const buttonsInstance = (
  <div>{BUTTONS.map(renderDropdownButton)}</div>
);

ReactDOM.render(buttonsInstance, document.getElementById('classdropdown'));
