import React, { Component } from 'react';
import './App.css';
import 'primeicons/primeicons.css';
import 'primereact/resources/themes/lara-light-cyan/theme.css';
import 'primereact/resources/primereact.min.css';

import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Panel } from 'primereact/panel';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { AprendizService } from './services/AprendizService';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      aprendices: [],
      aprendizDialog: false,
      aprendiz: {},
      isNew: true
    };
    this.aprendizService = new AprendizService();
    this.openNew = this.openNew.bind(this);
    this.hideDialog = this.hideDialog.bind(this);
    this.saveAprendiz = this.saveAprendiz.bind(this);
    this.editAprendiz = this.editAprendiz.bind(this);
    this.deleteAprendiz = this.deleteAprendiz.bind(this);
    this.onInputChange = this.onInputChange.bind(this);
  }

  componentDidMount() {
    this.aprendizService.getAll().then(data => {
      this.setState({ aprendices: data });
    }).catch(error => {
      console.error('Error fetching data:', error);
    });
  }

  openNew() {
    this.setState({
      aprendiz: {},
      aprendizDialog: true,
      isNew: true
    });
  }

  hideDialog() {
    this.setState({ aprendizDialog: false });
  }

  saveAprendiz() {
    if (this.state.isNew) {
      this.aprendizService.create(this.state.aprendiz).then(data => {
        this.setState(prevState => ({
          aprendices: [...prevState.aprendices, data],
          aprendizDialog: false,
          aprendiz: {}
        }));
      });
    } else {
      this.aprendizService.update(this.state.aprendiz).then(data => {
        const updatedAprendices = this.state.aprendices.map(aprendiz => 
          aprendiz.iduser === data.iduser ? data : aprendiz
        );
        this.setState({
          aprendices: updatedAprendices,
          aprendizDialog: false,
          aprendiz: {}
        });
      });
    }
  }

  editAprendiz(aprendiz) {
    this.setState({
      aprendiz: { ...aprendiz },
      aprendizDialog: true,
      isNew: false
    });
  }

  deleteAprendiz(id) {
    this.aprendizService.delete(id).then(() => {
      this.setState(prevState => ({
        aprendices: prevState.aprendices.filter(aprendiz => aprendiz.iduser !== id)
      }));
    });
  }

  onInputChange(e, name) {
    const val = (e.target && e.target.value) || '';
    let aprendiz = { ...this.state.aprendiz };
    aprendiz[name] = val;

    this.setState({ aprendiz });
  }

  render() {
    return (
      <Panel header='Gestion de aprendices' style={{ width: '80%', margin: '20px auto 0' }}>
        <div className="App">
          <Button label="Nuevo Aprendiz" icon="pi pi-plus" className="p-mb-2" onClick={this.openNew} />
          <DataTable value={this.state.aprendices} responsiveLayout="scroll">
            <Column field="iduser" header="ID" sortable></Column>
            <Column field="nomuser" header="Nombres" sortable></Column>
            <Column field="apellido" header="Apellidos" sortable></Column>
            <Column field="email" header="Email" sortable></Column>
            <Column body={rowData => (
              <>
                <Button icon="pi pi-pencil" className="p-button-rounded p-button-success p-mr-2" onClick={() => this.editAprendiz(rowData)} />
                <Button icon="pi pi-trash" className="p-button-rounded p-button-danger" onClick={() => this.deleteAprendiz(rowData.iduser)} />
              </>
            )} />
          </DataTable>

          <Dialog visible={this.state.aprendizDialog} style={{ width: '450px' }} header="Detalles del Aprendiz" modal className="p-fluid" onHide={this.hideDialog}>
            <div className="p-field">
              <label htmlFor="nomuser">Nombres</label>
              <InputText id="nomuser" value={this.state.aprendiz.nomuser} onChange={(e) => this.onInputChange(e, 'nomuser')} />
            </div>
            <div className="p-field">
              <label htmlFor="apellido">Apellidos</label>
              <InputText id="apellido" value={this.state.aprendiz.apellido} onChange={(e) => this.onInputChange(e, 'apellido')} />
            </div>
            <div className="p-field">
              <label htmlFor="email">Email</label>
              <InputText id="email" value={this.state.aprendiz.email} onChange={(e) => this.onInputChange(e, 'email')} />
            </div>
            <div className="p-dialog-footer">
              <Button label="Cancelar" icon="pi pi-times" className="p-button-text" onClick={this.hideDialog} />
              <Button label="Guardar" icon="pi pi-check" className="p-button-text" onClick={this.saveAprendiz} />
            </div>
          </Dialog>
        </div>
      </Panel>
    );
  }
}
