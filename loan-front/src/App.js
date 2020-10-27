import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import LoanForm from "./components/LoanForm";



class App extends Component {

	render(){
		return (
			<div>
				<LoanForm />
			</div>
		)
	}
}

export default App;
