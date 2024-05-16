'use client';
import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import axios from '../../../../lib/axios';
import LabeledInput from '../../components/Account/LabeledInput';
import LabeledSelect from '../../components/Account/LabeledSelect';
import { toast } from 'react-hot-toast';

export default function Account() {
  const id = useSelector((state) => state.id.value);
  const token = useSelector((state) => state.token.value);
  const [data, setData] = useState({});
  const [email, setEmail] = useState('');
  const [name, setName] = useState('');
  const [surname, setSurname] = useState('');
  const [sex, setSex] = useState(false);
  const [birthDate, setBirthDate] = useState('');
  const [education, setEducation] = useState('');
  const [profession, setProfession] = useState('');
  const [cityType, setCityType] = useState('');
  const [personalIdNumber, setPersonalIdNumber] = useState('');
  const [zipCode, setZipCode] = useState('');
  const [city, setCity] = useState('');
  const [country, setCountry] = useState('');
  const [addressLine, setAddressLine] = useState('');
  const fetchAccount = async () => {
    const res = await axios.get(`account/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    setData(res.data);
  };
  useEffect(() => {
    fetchAccount();
  }, []);
  useEffect(() => {
    if (data) {
      setEmail(data.email);
      setName(data.name);
      setSurname(data.surname);
      setSex(data.sex);
      const date = new Date(data.birthDate);
      const formattedDate = `${date.getFullYear()}-${(
        '0' +
        (date.getMonth() + 1)
      ).slice(-2)}-${('0' + date.getDate()).slice(-2)}`;
      setBirthDate(formattedDate);
      setEducation(data.education);
      setProfession(data.profession);
      setCityType(data.cityType);
      setPersonalIdNumber(data.personalIdNumber);
      setZipCode(data.zipCode);
      setCity(data.city);
      setCountry(data.country);
      setAddressLine(data.addressLine);
    }
  }, [data]);
  const onSubmit = async (e) => {
    e.preventDefault();
    const formData = {
      name,
      surname,
      sex,
      birthDate,
      education,
      profession,
      cityType,
      personalIdNumber,
      zip_code: zipCode,
      city,
      country,
      address_line: addressLine,
    };
    const sendEmail = async () => {
          try {
              const response = await axios.post('/api/email/sendEmail', {}, {
                  headers: {
                      Authorization: `Bearer ${token}`,
                  },
              });
              if (response.status === 200) {
                  toast.success('Email wysłany pomyślnie!');
              } else {
                  toast.error('Błąd wysyłania emaila. Spróbuj ponownie.');
              }
          } catch (error) {
              toast.error('Błąd wysyłania emaila. Spróbuj ponownie.');
          }
      };
    axios
      .put(`user/${id}`, formData, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => {
        if (res.status === 200) {
          toast.success('Dane zaktualizowane');
        }
      })
      .catch((err) => {
        toast.error('Błąd zapisu');
      });
  };

    function sendEmail() {
        axios.post('email/sendEmail', {}, {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        }).then((res) => {
            if (res.status === 200) {
                toast.success('Email wysłany pomyślnie!');
            } else {
                toast.error('Błąd wysyłania emaila. Spróbuj ponownie.');
            }
        }).catch((error) => {
            toast.error('Błąd wysyłania emaila. Spróbuj ponownie.');
        });
    }

    return (
    <div className='flex justify-center items-center relative top-35'>
      <div className='bg-slate-50 rounded-md border border-solid border-gray-500 grid grid-rows-3 grid-cols-1 justify-items-center items-center justify-evenly'>
        <div className='grid grid-rows-4 grid-cols-2 w-5/6 mt-4 gap-2'>
          <LabeledInput
            label='Email'
            value={email}
            type='email'
            onChange={(e) => setEmail(e.target.value)}
            placeholder='Podaj swój email'
            disabled
          />
          <LabeledInput
            label='Imię'
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder='Podaj swoje imię'
            type='text'
          />
          <LabeledInput
            label='Nazwisko'
            value={surname}
            onChange={(e) => setSurname(e.target.value)}
            placeholder='Podaj swoje nazwisko'
            type='text'
          />
          <LabeledSelect
            label='Płeć'
            value={sex}
            onChange={(e) => setSex(e.target.value)}
            options={[
              { label: 'Kobieta', value: true },
              { label: 'Mężczyzna', value: false },
            ]}
          />
          <LabeledInput
            label='Data urodzenia'
            value={birthDate}
            onChange={(e) => setBirthDate(e.target.value)}
            placeholder='Podaj swoją datę urodzenia'
            type='date'
          />
          <LabeledSelect
            label='Wykształcenie'
            value={education}
            onChange={(e) => setEducation(e.target.value)}
            options={[
              { label: 'Podstawowe', value: 'PRIMARY' },
              { label: 'Zawodowe', value: 'VOCATIONAL' },
              { label: 'Średnie', value: 'SECONDARY' },
              { label: 'Wyższe', value: 'POST_SECONDARY' },
            ]}
          />
          <LabeledInput
            label='Zawód'
            value={profession}
            onChange={(e) => setProfession(e.target.value)}
            placeholder='Podaj swój zawód'
            type='text'
          />
          <LabeledInput
            label='Numer PESEL'
            value={personalIdNumber}
            onChange={(e) => setPersonalIdNumber(e.target.value)}
            placeholder='Podaj swój PESEL'
            type='number'
          />
        </div>
        <div className='grid grid-rows-3 grid-cols-2 w-5/6 gap-2'>
          <LabeledSelect
            label='Typ miejscowości'
            value={cityType}
            onChange={(e) => setCityType(e.target.value)}
            options={[
              { label: 'Powyżej 500 tysięcy', value: 'OVER500THOUSAND' },
              {
                label: 'Pomiędzy 200 a 500 tysięcy',
                value: 'TWOHUNDREDTO500THOUSAND',
              },
              {
                label: 'Pomiędzy Poniżej 50 tysięcy',
                value: 'FIFTYTOTWOHUNDREDTHOUSAND',
              },
              { label: 'Poniżej 50 tysięcy', value: 'BELOWFIFTYTHOUSAND' },
            ]}
          />
          <LabeledInput
            label='Kod pocztowy'
            value={zipCode}
            onChange={(e) => setZipCode(e.target.value)}
            placeholder='Podaj swój kod pocztowy'
            type='text'
          />
          <LabeledInput
            label='Adres'
            value={addressLine}
            onChange={(e) => setAddressLine(e.target.value)}
            placeholder='Podaj swój adres'
            type='text'
          />
          <LabeledInput
            label='Miasto'
            value={city}
            onChange={(e) => setCity(e.target.value)}
            placeholder='Podaj swoje miasto'
            type='text'
          />
          <LabeledSelect
            label='Kraj'
            value={country}
            onChange={(e) => setCountry(e.target.value)}
            options={[
              { label: 'Afghanistan', value: 'Afghanistan' },
              { label: 'Åland Islands', value: 'Åland Islands' },
              { label: 'Albania', value: 'Albania' },
              { label: 'Algeria', value: 'Algeria' },
              { label: 'American Samoa', value: 'American Samoa' },
              { label: 'Andorra', value: 'Andorra' },
              { label: 'Angola', value: 'Angola' },
              { label: 'Anguilla', value: 'Anguilla' },
              { label: 'Antarctica', value: 'Antarctica' },
              { label: 'Antigua and Barbuda', value: 'Antigua and Barbuda' },
              { label: 'Argentina', value: 'Argentina' },
              { label: 'Armenia', value: 'Armenia' },
              { label: 'Aruba', value: 'Aruba' },
              { label: 'Australia', value: 'Australia' },
              { label: 'Austria', value: 'Austria' },
              { label: 'Azerbaijan', value: 'Azerbaijan' },
              { label: 'Bahamas', value: 'Bahamas' },
              { label: 'Bahrain', value: 'Bahrain' },
              { label: 'Bangladesh', value: 'Bangladesh' },
              { label: 'Barbados', value: 'Barbados' },
              { label: 'Belarus', value: 'Belarus' },
              { label: 'Belgium', value: 'Belgium' },
              { label: 'Belize', value: 'Belize' },
              { label: 'Benin', value: 'Benin' },
              { label: 'Bermuda', value: 'Bermuda' },
              { label: 'Bhutan', value: 'Bhutan' },
              { label: 'Bolivia', value: 'Bolivia' },
              {
                label: 'Bosnia and Herzegovina',
                value: 'Bosnia and Herzegovina',
              },
              { label: 'Botswana', value: 'Botswana' },
              { label: 'Bouvet Island', value: 'Bouvet Island' },
              { label: 'Brazil', value: 'Brazil' },
              {
                label: 'British Indian Ocean Territory',
                value: 'British Indian Ocean Territory',
              },
              { label: 'Brunei Darussalam', value: 'Brunei Darussalam' },
              { label: 'Bulgaria', value: 'Bulgaria' },
              { label: 'Burkina Faso', value: 'Burkina Faso' },
              { label: 'Burundi', value: 'Burundi' },
              { label: 'Cambodia', value: 'Cambodia' },
              { label: 'Cameroon', value: 'Cameroon' },
              { label: 'Canada', value: 'Canada' },
              { label: 'Cape Verde', value: 'Cape Verde' },
              { label: 'Cayman Islands', value: 'Cayman Islands' },
              {
                label: 'Central African Republic',
                value: 'Central African Republic',
              },
              { label: 'Chad', value: 'Chad' },
              { label: 'Chile', value: 'Chile' },
              { label: 'China', value: 'China' },
              { label: 'Christmas Island', value: 'Christmas Island' },
              {
                label: 'Cocos (Keeling) Islands',
                value: 'Cocos (Keeling) Islands',
              },
              { label: 'Colombia', value: 'Colombia' },
              { label: 'Comoros', value: 'Comoros' },
              { label: 'Congo', value: 'Congo' },
              {
                label: 'Congo, The Democratic Republic of The',
                value: 'Congo, The Democratic Republic of The',
              },
              { label: 'Cook Islands', value: 'Cook Islands' },
              { label: 'Costa Rica', value: 'Costa Rica' },
              { label: "Cote D'ivoire", value: "Cote D'ivoire" },
              { label: 'Croatia', value: 'Croatia' },
              { label: 'Cuba', value: 'Cuba' },
              { label: 'Cyprus', value: 'Cyprus' },
              { label: 'Czech Republic', value: 'Czech Republic' },
              { label: 'Denmark', value: 'Denmark' },
              { label: 'Djibouti', value: 'Djibouti' },
              { label: 'Dominica', value: 'Dominica' },
              { label: 'Dominican Republic', value: 'Dominican Republic' },
              { label: 'Ecuador', value: 'Ecuador' },
              { label: 'Egypt', value: 'Egypt' },
              { label: 'El Salvador', value: 'El Salvador' },
              { label: 'Equatorial Guinea', value: 'Equatorial Guinea' },
              { label: 'Eritrea', value: 'Eritrea' },
              { label: 'Estonia', value: 'Estonia' },
              { label: 'Ethiopia', value: 'Ethiopia' },
              {
                label: 'Falkland Islands (Malvinas)',
                value: 'Falkland Islands (Malvinas)',
              },
              { label: 'Faroe Islands', value: 'Faroe Islands' },
              { label: 'Fiji', value: 'Fiji' },
              { label: 'Finland', value: 'Finland' },
              { label: 'France', value: 'France' },
              { label: 'French Guiana', value: 'French Guiana' },
              { label: 'French Polynesia', value: 'French Polynesia' },
              {
                label: 'French Southern Territories',
                value: 'French Southern Territories',
              },
              { label: 'Gabon', value: 'Gabon' },
              { label: 'Gambia', value: 'Gambia' },
              { label: 'Georgia', value: 'Georgia' },
              { label: 'Germany', value: 'Germany' },
              { label: 'Ghana', value: 'Ghana' },
              { label: 'Gibraltar', value: 'Gibraltar' },
              { label: 'Greece', value: 'Greece' },
              { label: 'Greenland', value: 'Greenland' },
              { label: 'Grenada', value: 'Grenada' },
              { label: 'Guadeloupe', value: 'Guadeloupe' },
              { label: 'Guam', value: 'Guam' },
              { label: 'Guatemala', value: 'Guatemala' },
              { label: 'Guernsey', value: 'Guernsey' },
              { label: 'Guinea', value: 'Guinea' },
              { label: 'Guinea-bissau', value: 'Guinea-bissau' },
              { label: 'Guyana', value: 'Guyana' },
              { label: 'Haiti', value: 'Haiti' },
              {
                label: 'Heard Island and Mcdonald Islands',
                value: 'Heard Island and Mcdonald Islands',
              },
              {
                label: 'Holy See (Vatican City State)',
                value: 'Holy See (Vatican City State)',
              },
              { label: 'Honduras', value: 'Honduras' },
              { label: 'Hong Kong', value: 'Hong Kong' },
              { label: 'Hungary', value: 'Hungary' },
              { label: 'Iceland', value: 'Iceland' },
              { label: 'India', value: 'India' },
              { label: 'Indonesia', value: 'Indonesia' },
              {
                label: 'Iran, Islamic Republic of',
                value: 'Iran, Islamic Republic of',
              },
              { label: 'Iraq', value: 'Iraq' },
              { label: 'Ireland', value: 'Ireland' },
              { label: 'Isle of Man', value: 'Isle of Man' },
              { label: 'Israel', value: 'Israel' },
              { label: 'Italy', value: 'Italy' },
              { label: 'Jamaica', value: 'Jamaica' },
              { label: 'Japan', value: 'Japan' },
              { label: 'Jersey', value: 'Jersey' },
              { label: 'Jordan', value: 'Jordan' },
              { label: 'Kazakhstan', value: 'Kazakhstan' },
              { label: 'Kenya', value: 'Kenya' },
              { label: 'Kiribati', value: 'Kiribati' },
              {
                label: "Korea, Democratic People's Republic of",
                value: "Korea, Democratic People's Republic of",
              },
              { label: 'Korea, Republic of', value: 'Korea, Republic of' },
              { label: 'Kuwait', value: 'Kuwait' },
              { label: 'Kyrgyzstan', value: 'Kyrgyzstan' },
              {
                label: "Lao People's Democratic Republic",
                value: "Lao People's Democratic Republic",
              },
              { label: 'Latvia', value: 'Latvia' },
              { label: 'Lebanon', value: 'Lebanon' },
              { label: 'Lesotho', value: 'Lesotho' },
              { label: 'Liberia', value: 'Liberia' },
              {
                label: 'Libyan Arab Jamahiriya',
                value: 'Libyan Arab Jamahiriya',
              },
              { label: 'Liechtenstein', value: 'Liechtenstein' },
              { label: 'Lithuania', value: 'Lithuania' },
              { label: 'Luxembourg', value: 'Luxembourg' },
              { label: 'Macao', value: 'Macao' },
              {
                label: 'Macedonia, The Former Yugoslav Republic of',
                value: 'Macedonia, The Former Yugoslav Republic of',
              },
              { label: 'Madagascar', value: 'Madagascar' },
              { label: 'Malawi', value: 'Malawi' },
              { label: 'Malaysia', value: 'Malaysia' },
              { label: 'Maldives', value: 'Maldives' },
              { label: 'Mali', value: 'Mali' },
              { label: 'Malta', value: 'Malta' },
              { label: 'Marshall Islands', value: 'Marshall Islands' },
              { label: 'Martinique', value: 'Martinique' },
              { label: 'Mauritania', value: 'Mauritania' },
              { label: 'Mauritius', value: 'Mauritius' },
              { label: 'Mayotte', value: 'Mayotte' },
              { label: 'Mexico', value: 'Mexico' },
              {
                label: 'Micronesia, Federated States of',
                value: 'Micronesia, Federated States of',
              },
              { label: 'Moldova, Republic of', value: 'Moldova, Republic of' },
              { label: 'Monaco', value: 'Monaco' },
              { label: 'Mongolia', value: 'Mongolia' },
              { label: 'Montenegro', value: 'Montenegro' },
              { label: 'Montserrat', value: 'Montserrat' },
              { label: 'Morocco', value: 'Morocco' },
              { label: 'Mozambique', value: 'Mozambique' },
              { label: 'Myanmar', value: 'Myanmar' },
              { label: 'Namibia', value: 'Namibia' },
              { label: 'Nauru', value: 'Nauru' },
              { label: 'Nepal', value: 'Nepal' },
              { label: 'Netherlands', value: 'Netherlands' },
              { label: 'Netherlands Antilles', value: 'Netherlands Antilles' },
              { label: 'New Caledonia', value: 'New Caledonia' },
              { label: 'New Zealand', value: 'New Zealand' },
              { label: 'Nicaragua', value: 'Nicaragua' },
              { label: 'Niger', value: 'Niger' },
              { label: 'Nigeria', value: 'Nigeria' },
              { label: 'Niue', value: 'Niue' },
              { label: 'Norfolk Island', value: 'Norfolk Island' },
              {
                label: 'Northern Mariana Islands',
                value: 'Northern Mariana Islands',
              },
              { label: 'Norway', value: 'Norway' },
              { label: 'Oman', value: 'Oman' },
              { label: 'Pakistan', value: 'Pakistan' },
              { label: 'Palau', value: 'Palau' },
              {
                label: 'Palestinian Territory, Occupied',
                value: 'Palestinian Territory, Occupied',
              },
              { label: 'Panama', value: 'Panama' },
              { label: 'Papua New Guinea', value: 'Papua New Guinea' },
              { label: 'Paraguay', value: 'Paraguay' },
              { label: 'Peru', value: 'Peru' },
              { label: 'Philippines', value: 'Philippines' },
              { label: 'Pitcairn', value: 'Pitcairn' },
              { label: 'Poland', value: 'Poland' },
              { label: 'Portugal', value: 'Portugal' },
              { label: 'Puerto Rico', value: 'Puerto Rico' },
              { label: 'Qatar', value: 'Qatar' },
              { label: 'Reunion', value: 'Reunion' },
              { label: 'Romania', value: 'Romania' },
              { label: 'Russian Federation', value: 'Russian Federation' },
              { label: 'Rwanda', value: 'Rwanda' },
              { label: 'Saint Helena', value: 'Saint Helena' },
              {
                label: 'Saint Kitts and Nevis',
                value: 'Saint Kitts and Nevis',
              },
              { label: 'Saint Lucia', value: 'Saint Lucia' },
              {
                label: 'Saint Pierre and Miquelon',
                value: 'Saint Pierre and Miquelon',
              },
              {
                label: 'Saint Vincent and The Grenadines',
                value: 'Saint Vincent and The Grenadines',
              },
              { label: 'Samoa', value: 'Samoa' },
              { label: 'San Marino', value: 'San Marino' },
              {
                label: 'Sao Tome and Principe',
                value: 'Sao Tome and Principe',
              },
              { label: 'Saudi Arabia', value: 'Saudi Arabia' },
              { label: 'Senegal', value: 'Senegal' },
              { label: 'Serbia', value: 'Serbia' },
              { label: 'Seychelles', value: 'Seychelles' },
              { label: 'Sierra Leone', value: 'Sierra Leone' },
              { label: 'Singapore', value: 'Singapore' },
              { label: 'Slovakia', value: 'Slovakia' },
              { label: 'Slovenia', value: 'Slovenia' },
              { label: 'Solomon Islands', value: 'Solomon Islands' },
              { label: 'Somalia', value: 'Somalia' },
              { label: 'South Africa', value: 'South Africa' },
              {
                label: 'South Georgia and The South Sandwich Islands',
                value: 'South Georgia and The South Sandwich Islands',
              },
              { label: 'Spain', value: 'Spain' },
              { label: 'Sri Lanka', value: 'Sri Lanka' },
              { label: 'Sudan', value: 'Sudan' },
              { label: 'Suriname', value: 'Suriname' },
              {
                label: 'Svalbard and Jan Mayen',
                value: 'Svalbard and Jan Mayen',
              },
              { label: 'Swaziland', value: 'Swaziland' },
              { label: 'Sweden', value: 'Sweden' },
              { label: 'Switzerland', value: 'Switzerland' },
              { label: 'Syrian Arab Republic', value: 'Syrian Arab Republic' },
              { label: 'Taiwan', value: 'Taiwan' },
              { label: 'Tajikistan', value: 'Tajikistan' },
              {
                label: 'Tanzania, United Republic of',
                value: 'Tanzania, United Republic of',
              },
              { label: 'Thailand', value: 'Thailand' },
              { label: 'Timor-leste', value: 'Timor-leste' },
              { label: 'Togo', value: 'Togo' },
              { label: 'Tokelau', value: 'Tokelau' },
              { label: 'Tonga', value: 'Tonga' },
              { label: 'Trinidad and Tobago', value: 'Trinidad and Tobago' },
              { label: 'Tunisia', value: 'Tunisia' },
              { label: 'Turkey', value: 'Turkey' },
              { label: 'Turkmenistan', value: 'Turkmenistan' },
              {
                label: 'Turks and Caicos Islands',
                value: 'Turks and Caicos Islands',
              },
              { label: 'Tuvalu', value: 'Tuvalu' },
              { label: 'Uganda', value: 'Uganda' },
              { label: 'Ukraine', value: 'Ukraine' },
              { label: 'United Arab Emirates', value: 'United Arab Emirates' },
              { label: 'United Kingdom', value: 'United Kingdom' },
              { label: 'United States', value: 'United States' },
              {
                label: 'United States Minor Outlying Islands',
                value: 'United States Minor Outlying Islands',
              },
              { label: 'Uruguay', value: 'Uruguay' },
              { label: 'Uzbekistan', value: 'Uzbekistan' },
              { label: 'Vanuatu', value: 'Vanuatu' },
              { label: 'Venezuela', value: 'Venezuela' },
              { label: 'Viet Nam', value: 'Viet Nam' },
              {
                label: 'Virgin Islands, British',
                value: 'Virgin Islands, British',
              },
              { label: 'Virgin Islands, U.S.', value: 'Virgin Islands, U.S.' },
              { label: 'Wallis and Futuna', value: 'Wallis and Futuna' },
              { label: 'Western Sahara', value: 'Western Sahara' },
              { label: 'Yemen', value: 'Yemen' },
              { label: 'Zambia', value: 'Zambia' },
              { label: 'Zimbabwe', value: 'Zimbabwe' },
            ]}
          />
            <button
                onClick={sendEmail}
                className='bg-blue-500 rounded-md w-1/1 h-1/1 text-white'
            >
                Wygeneruj swój kod do głosowania
            </button>
        </div>
          <button
              onClick={onSubmit}
              className='bg-green-500 rounded-md w-1/5 h-1/5 text-white'
          >
              Zapisz
          </button>
      </div>
    </div>
  );
}
