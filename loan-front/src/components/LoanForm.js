import React, { Component } from 'react'
import { Form, Row, Col, Button } from 'react-bootstrap'

import LoanResult from "./LoanResult";


export default class LoanForm extends Component {

	constructor(props) {
		super(props);
		this.state = {
			tcNo: "",
			fullName: "",
			phoneNumber: "",
			monthlyIncome: "",
			loanResult: {
				status: false,
				limit: 0
			},
			display: false,
		};
	}

	sendForm = async () => {

		var myHeaders = new Headers();
		myHeaders.append("Content-Type", "application/json");
		myHeaders.append("Access-Control-Allow-Origin", "*");

		var requestOptions = {
			method: 'PUT',
			headers: myHeaders,
			body: JSON.stringify({
				tcNo: this.state.tcNo,
			}),
			redirect: 'follow'
		};

		await fetch("http://localhost:8080/loan", requestOptions)
			.then(response => response.json())
			.then(result => {
				console.log(result)
				this.setState(this.state.loanResult = {
					status: result.loanResult,
					limit: result.loanLimit
				})
			})
			.catch(error => console.log(error));
		this.setState({ display: true })

	}

	render() {
		return (
			<div className="container col-lg-12 col-md-8 app" >
				<div className="loanForm">
					<Form>
						<Form.Group as={Row} controlId="formPlaintextTcNo">
							<Form.Label column sm="2" lg="6">
								T.C. Kimlik Numarası
    					</Form.Label>
							<Col sm="10" lg="6">
								<Form.Control
									onChange={(event) => this.setState({ tcNo: event.target.value })}
								/>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="formPlaintextFullName">
							<Form.Label column sm="2" lg="6">
								Ad Soyad
    					</Form.Label>
							<Col sm="10" lg="6">
								<Form.Control
									onChange={(event) => this.setState({ fullName: event.target.value })}
								/>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="formPlaintextPhoneNumber">
							<Form.Label column sm="2" lg="6">
								Telefon Numarası
						</Form.Label>
							<Col sm="10" lg="6">
								<Form.Control
									onChange={(event) => this.setState({ phoneNumber: event.target.value })}
								/>
							</Col>
						</Form.Group>

						<Form.Group as={Row} controlId="formPlaintextMonthlyIncome">
							<Form.Label column sm="2" lg="6">
								Aylık Gelir
						</Form.Label>
							<Col sm="10" lg="6">
								<Form.Control
									onChange={(event) => this.setState({ monthlyIncome: event.target.value })}
								/>
							</Col>
						</Form.Group>
					</Form>
					<Button
						onClick={this.sendForm}
						className="col-lg-12 col-md-12" type="button" variant="primary">
						Gönder
					</Button>
				</div>
				<div
					className="loanForm"
					style={{ display: this.state.display ? 'flex' : 'none' }}
				>
					<LoanResult
						result={this.state.loanResult}
						personInfo={this.state.fullName}
					/>
				</div>
			</div>
		);
	}
}
