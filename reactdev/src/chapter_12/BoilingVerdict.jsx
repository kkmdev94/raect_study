function BoilingVerdict(props) {
    if (props.celsius >= 100) {
        return <p>water boils</p>
    }
    return <p>water not boils</p>
}

// function Calculator(props) {
//     const [temperature, setTemperature] = useState('');
//     const [scale, setScale] = useState('');
    
//     const handleCelsiusChange = (temperature) => {
//         setTemperature(temperature);
//         setScale('c');
//     }

//     const handleFahrenheitChange = (temperature) => {
//         setTemperature(temperature);
//         setScale('f');
//     }

//     const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature;
//     const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenheit) : temperature;

//     return (
//         <div>
//             <TemperatureInput
//                 scale="c"
//                 temperature={celsius}
//                 onTemperatureChange={handleCelsiusChange} />
//             <TemperatureInput
//                 scale="f"
//                 temperature={fahrenheit}
//                 onTemperatureChange={handleFahrenheitChange} />
//             <BoilingVerdict
//                 celsius={parseFloat(celsius)} />
//         </div>
//     );
// }

// const scaleNames = {
//     c: '섭씨',
//     f: '화씨'
// };

// function TemperatureInput(props) {
//     // const [temperature, setTemperature] = useState('');

//     const handleChange = (event) => {
//         props.onTemperatureChange(event.target.value);
//     }

//     return (
//         <fieldset>
//             <legend>
//                 온도를 입력해 주세요(단위{scaleNames[props.scale]}):
//             </legend>
//             {/* <input value={temperature} onChange={handleChange} /> */}
//             <input value={props.temperature} onChange={handleChange} />
//         </fieldset>
//     )
// }

function toCelsius(fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
}

function toFahrenheit(celsius) {
    return (celsius * 9 / 5) + 32;
}

function tryConvert(temperature, convert) {
    const input = parseFloat(temperature);
    if (Number.isNaN(input)) {
        return '';
    }
    const output = convert(input);
    const rounded = Math.round(output * 1000) / 1000;
    return rounded.toString();
}