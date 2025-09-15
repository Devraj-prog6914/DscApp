const express = require('express');
const twilio = require('twilio');
const app = express();
app.use(express.json());

const accountSid = 'AC0d06c28da64b27e98a1eee9c8851be6e';
const authToken = '8cb3b957823e3327412f1213698e181d';
const client = twilio(accountSid, authToken);

const otps = {}; // store OTPs in memory (for dev)

function generateOTP() {
    return Math.floor(100000 + Math.random() * 900000).toString();
}

app.post('/send-otp', (req, res) => {
    const { phone } = req.body;
    const otp = generateOTP();
    otps[phone] = otp;

    client.messages
        .create({
            body: `Your OTP is ${otp}`,
            from: '',
            to: phone
        })
        .then(message => res.json({ success: true }))
        .catch(err => res.json({ success: false, error: err.message }));
});

app.post('/verify-otp', (req, res) => {
    const { phone, otp } = req.body;
    if (otps[phone] && otps[phone] === otp) {
        delete otps[phone];
        res.json({ success: true });
    } else {
        res.json({ success: false });
    }
});

app.listen(3000, () => console.log('Server running on port 3000'));
