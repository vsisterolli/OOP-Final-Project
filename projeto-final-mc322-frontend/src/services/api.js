import axios from "axios";
import { API_BASE_URL } from "../util/constants";

const instance = axios.create({
	baseURL: API_BASE_URL,
});

export const externalInstance = axios.create();

export default instance;