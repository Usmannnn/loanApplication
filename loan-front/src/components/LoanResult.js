import React, { Component } from 'react'
import { Card, Navbar } from 'react-bootstrap'



export class LoanResult extends Component {

    render() {
        return (
            <div>
                {
                    <div>
                        <Navbar bg='dark' variant='dark'>
                            <Navbar.Brand>Kredi Başvuru Sonucu</Navbar.Brand>
                        </Navbar>
                        <Card>
                            <Card.Body>
                                <Card.Title>Sayın {this.props.personInfo},</Card.Title>
                                <Card.Text>
                                    Kredi Başvurunuz Sonuçlanmıştır.
                                </Card.Text>
                                {
                                    this.props.result.status ?
                                        <Card.Text>
                                            Kredi Durumu: Onaylandı.
                                        </Card.Text>
                                        :
                                        <Card.Text>
                                            Kredi Durumu: Reddedildi.
                                        </Card.Text>
                                }
                                <Card.Text>
                                    Kredi Limiti: {this.props.result.limit} TL
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </div>
                }
            </div>
        )
    }
}

export default LoanResult
