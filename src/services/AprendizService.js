import axios from "axios";

export class AprendizService {
  baseUrl = "http://localhost:8080/Aprendiz";

  getAll() {
    return axios.get(this.baseUrl + "/mostrar").then(res => res.data);
  }

  create(aprendiz) {
    return axios.post(this.baseUrl + "/crear", aprendiz).then(res => res.data);
  }

  update(aprendiz) {
    return axios.put(this.baseUrl + `/actualizar/${aprendiz.iduser}`, aprendiz).then(res => res.data);
  }

  delete(id) {
    return axios.delete(this.baseUrl + `/eliminar/${id}`).then(res => res.data);
  }
}
