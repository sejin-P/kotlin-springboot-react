import React, {Component} from 'react';
import EmployeeService from "../services/EmployeeService";

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            first_name: '',
            last_name: '',
            email_id: ''
        }
    }

    changeFirstNameHandler = (event) => {
        // https://reactjs.org/docs/forms.html#controlled-components
        this.setState({first_name: event.target.value})
    }

    changeSecondNameHandler = (event) => {
        this.setState({last_name: event.target.value})
    }

    changeEmailHandler = (event) => {
        this.setState({email_id: event.target.value})
    }

    saveEmployee = (e) => {
        e.preventDefault();
        const employee = {
            first_name: this.state.first_name,
            last_name: this.state.last_name,
            email_id: this.state.email_id
        }

        EmployeeService.createEmployee(employee).then(res => {
            window.location = '/employees';
        });
    }

    cancel = () => {
        window.location = '/employees';
    }

    render() {
        return (
            <div>
                <div className={"container"}>
                    <div className={"row"}>
                        <div className={"card col-md-6 offset-md-3 offset-md-3"}>
                            <h3 className={"text-center"}>Add Employee</h3>
                            <div className={"card-body"}>
                                <form>
                                    <div className={"form-group"}>
                                        <label> First name:</label>
                                        <input
                                            placeholder={"First name"}
                                            name={"first_name"}
                                            className={"form-control"}
                                            value={this.state.first_name}
                                            onChange = {this.changeFirstNameHandler}
                                        />
                                    </div>
                                    <div className={"form-group"}>
                                        <label> Last name:</label>
                                        <input
                                            placeholder={"Last name"}
                                            name={"last_name"}
                                            className={"form-control"}
                                            value = {this.state.last_name}
                                            onChange = {this.changeSecondNameHandler}
                                        />
                                    </div>
                                    <div className={"form-group"}>
                                        <label> Email id:</label>
                                        <input
                                            placeholder={"Email id"}
                                            name={"email_id"}
                                            className={"form-control"}
                                            value={this.state.email_id}
                                            onChange = {this.changeEmailHandler}
                                        />
                                    </div>

                                    <button className={"btn btn-success"} onClick={this.saveEmployee}>Save</button>
                                    <button className={"btn btn-danger"} onClick={this.cancel} style={{marginLeft: "10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateEmployeeComponent;