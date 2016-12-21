import React from 'react'


export default React.createClass({

  render() {
    return (
    <div>
    	<section className="container">
    		<div className="macro">
    			<h1>Failed Macros</h1>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <tr>
                            <th></th>
                            <th>Macro</th>
                            <th>Date Run</th>
                            <th>Run By</th>
                            <th>Reviewer</th>
                        </tr>
                    </table>
                </div>
    		</div>
    	</section>
    </div>
    )
  }

})