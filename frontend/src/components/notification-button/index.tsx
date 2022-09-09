import icon from '../../assets/img/notification-icon.svg';
import axios from "axios";
import { BASE_URL } from "../../utils/request";

import './styles.css';
import { toast } from 'react-toastify';

type Props = {
    saleId: number;
}

function NotificationButton({ saleId }: Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

function handleClick(saleId: number) {
    axios.get(`${BASE_URL}/sales/${saleId}/notification`).then(response => {
        toast.info("SMS sending successfully.")
    })
}

export default NotificationButton;
