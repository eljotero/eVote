'use client';
import React, {useEffect, useState} from 'react';
import {useSelector} from 'react-redux';
import {z} from 'zod';
import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";
import axios from "../../../../lib/axios";
import LabeledInput
    from "@/app/components/Account/LabeledInput";
import LabeledSelect
    from "@/app/components/Account/LabeledSelect";
import {toast} from "react-hot-toast";
import Image from 'next/image';
import evote from '../../../../public/images/evote-account.png';
import evote2 from '../../../../public/images/evote-account2.png';

const personInfoSchema = z.object({
    email: z.string({message: 'Pole wymagane'}).email({ message: 'Nieprawidłowy adres email' }),
    name: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    surname: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    sex: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    birthDate: z.string({message: 'Pole wymagane'}).refine((val) => !isNaN(Date.parse(val)), { message: 'Pole wymagane' }),
    education: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    profession: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    cityType: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    personalIdNumber: z.string({message: 'Pole wymagane'}).min(11, 'PESEL musi mieć 11 cyfr'),
    zipCode: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    city: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    country: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    addressLine: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
    voivodeship: z.string({message: 'Pole wymagane'}).min(1, {message: 'Pole wymagane'}),
}).refine((data) => {
    const today = new Date();
    const birthDate = new Date(data.birthDate);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age >= 18;
}, {
    message: 'Musisz mieć ukończone 18 lat',
    path: ['birthDate']
});

export default function Account() {
    const id = useSelector((state) => state.id.value);
    const token = useSelector((state) => state.token.value);
    const [data, setData] = useState({});
    const [emailSent, setEmailSent] = useState(false);
    const {
        register,
        handleSubmit,
        formState: {errors, isSubmitting},
        setValue
    } = useForm({
        resolver: zodResolver(personInfoSchema),
    });
    const fetchAccount = async () => {
        console.log(id);
        console.log(token);
        const res = await axios.get(`account/${id}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });
        setData(res.data);
    };

    useEffect(() => {
        if (data) {
            const date = new Date(data.birthDate);
            const formattedDate = `${date.getFullYear()}-${(
                '0' +
                (date.getMonth() + 1)
            ).slice(-2)}-${('0' + date.getDate()).slice(-2)}`;
            setValue('birthDate', formattedDate);
            setValue('education', data.education);
            setValue('profession', data.profession);
            setValue('cityType', data.cityType);
            setValue('personalIdNumber', data.personalIdNumber);
            setValue('zipCode', data.zipCode);
            setValue('city', data.city);
            setValue('country', data.country);
            setValue('addressLine', data.addressLine);
            setValue('voivodeship', data.voivodeship);
        }
    }, [data, setValue]);


    const onSubmit = async (data) => {
        const formData = {
            name: data.name,
            surname: data.surname,
            sex: (data.sex === 'true'),
            birthDate: data.birthDate,
            education: data.education,
            profession: data.profession,
            cityType: data.cityType,
            personalIdNumber: data.personalIdNumber,
            zip_code: data.zipCode,
            voivodeship: data.voivodeship,
            city: data.city,
            country: data.country,
            address_line: data.addressLine,
        };
        console.log(id);
        console.log(token);
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
        axios
            .post(
                'email/sendEmail',
                {},
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                }
            )
            .then((res) => {
                if (res.status === 200) {
                    toast.success('Email wysłany pomyślnie!');
                }
            })
            .catch((error) => {
                if (error.response.status === 400) {
                    toast.error(
                        'Email został już wysłany. Sprawdź swoją skrzynkę odbiorczą.'
                    );
                    return;
                }
                toast.error('Błąd wysyłania emaila. Spróbuj ponownie.');
            });
    }

    return (
        <section className="py-1 h-auto flex items-center relative" aria-label="Sekcja informacji o koncie">
            <div className="absolute left-0 top-1/2 -translate-y-1/2 w-1/4">
                <Image src={evote2} alt="Megafon" className="relative" loading='lazy'
                       layout='responsive'/>
            </div>
            <div className="absolute right-0 top-1/2 -translate-y-1/2 w-1/4">
                <Image src={evote} alt="Dłoń trzymająca telefon" className="relative" loading='lazy'
                       layout='responsive'/>
            </div>

            <div className="sm:w-8/12 lg:w-6/12 px-4 mx-auto mt-16">
                <div
                    className="relative flex flex-col min-w-0 w-full mb-6 shadow-lg rounded-lg border bg-gray-100 border-gray-200 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 duration-300">
                    <div className="rounded-t mb-0 px-6 py-6">
                        <div className="text-center flex justify-between">
                            <h6 className="text-xl font-bold px-4 py-2">Moje konto</h6>
                            <button
                                className="border-0 px-4 py-2 rounded shadow font-bold bg-blue-400 hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-500/20 text-white duration-300"
                                onClick={sendEmail}
                                aria-label='Wygeneruj kod'>
                                Wygeneruj kod do głosowania
                            </button>
                        </div>
                        <hr className="mt-6 border-b-1 border-gray-300"/>
                    </div>
                    <div className="flex-auto px-4 lg:px-10 py-10 pt-0">
                        <form onSubmit={handleSubmit(onSubmit)}>
                            <h6 className="text-sm mt-3 mb-6 font-bold uppercase">
                                Informacje osobiste
                            </h6>
                            <div className="grid grid-cols-2 gap-4">
                                <LabeledInput
                                    label='Email'
                                    register={register}
                                    name='email'
                                    type='email'
                                    error={errors.email}
                                    disabled={true}
                                    placeholder={'Podaj swój email'}
                                />
                                <LabeledInput
                                    label='Imię'
                                    register={register}
                                    name='name'
                                    type='text'
                                    error={errors.name}
                                    disabled={false}
                                    placeholder={'Podaj swoje imię'}
                                />
                                <LabeledInput
                                    label='Nazwisko'
                                    register={register}
                                    name='surname'
                                    type='text'
                                    error={errors.surname}
                                    disabled={false}
                                    placeholder={'Podaj swoje nazwisko'}
                                />
                                <LabeledSelect
                                    label="Płeć"
                                    register={register}
                                    name="sex"
                                    options={[
                                        {label: "Kobieta", value: true},
                                        {label: "Mężczyzna", value: false},
                                    ]}
                                    error={errors.sex}
                                    title="Jaka jest Twoja płeć?"
                                />

                                <LabeledInput
                                    label='Data urodzenia'
                                    register={register}
                                    name='birthDate'
                                    type='date'
                                    error={errors.birthDate}
                                    disabled={false}
                                    placeholder={'Podaj swoją datę urodzenia'}
                                />
                                <LabeledSelect
                                    label="Wykształcenie"
                                    register={register}
                                    name="education"
                                    options={[
                                        {label: "Podstawowe", value: "PRIMARY"},
                                        {label: "Zawodowe", value: "VOCATIONAL"},
                                        {label: "Średnie", value: "SECONDARY"},
                                        {label: "Wyższe", value: "POST_SECONDARY"},
                                    ]}
                                    error={errors.education}
                                    title="Jakie jest Twoje wykształcenie?"
                                />

                                <LabeledInput
                                    label='Zawód'
                                    register={register}
                                    name='profession'
                                    type='text'
                                    error={errors.profession}
                                    disabled={false}
                                    placeholder={'Podaj swój zawód'}
                                />
                                <LabeledInput
                                    label='Numer PESEL'
                                    register={register}
                                    name='personalIdNumber'
                                    type='number'
                                    error={errors.personalIdNumber}
                                    disabled={false}
                                    placeholder={'Podaj swój numer PESEL'}
                                />
                            </div>
                            <hr className="mt-6 border-b-1 border-gray-300"/>
                            <h6 className="text-sm mt-3 mb-6 font-bold uppercase">
                                Adres zamieszkania
                            </h6>
                            <div className="grid grid-cols-2 gap-4 mt-6">
                                <LabeledInput
                                    label='Kod pocztowy'
                                    register={register}
                                    name='zipCode'
                                    type='text'
                                    error={errors.zipCode}
                                    disabled={false}
                                    placeholder={'Podaj swój kod pocztowy'}
                                />
                                <LabeledInput
                                    label='Adres'
                                    register={register}
                                    name='addressLine'
                                    type='text'
                                    error={errors.addressLine}
                                    disabled={false}
                                    placeholder={'Podaj swój adres'}
                                />
                                <LabeledInput
                                    label='Miasto'
                                    register={register}
                                    name='city'
                                    type='text'
                                    error={errors.city}
                                    disabled={false}
                                    placeholder={'Podaj swoje miasto'}
                                />
                                <LabeledSelect
                                    label='Typ miejscowości'
                                    register={register}
                                    name='cityType'
                                    options={[
                                        {
                                            label: 'Powyżej 500 tysięcy',
                                            value: 'OVER500THOUSAND'
                                        },
                                        {
                                            label: 'Pomiędzy 200 a 500 tysięcy',
                                            value: 'TWOHUNDREDTO500THOUSAND'
                                        },
                                        {
                                            label: 'Pomiędzy 50 a 200 tysięcy',
                                            value: 'FIFTYTOTWOHUNDREDTHOUSAND'
                                        },
                                        {
                                            label: 'Poniżej 50 tysięcy',
                                            value: 'BELOWFIFTYTHOUSAND'
                                        },
                                    ]}
                                    error={errors.cityType}
                                    title={'Jaki jest typ Twojej miejscowości?'}
                                />
                                <LabeledSelect
                                    label='Kraj'
                                    register={register}
                                    name='country'
                                    options={[
                                        {
                                            label: 'Afghanistan',
                                            value: 'Afghanistan'
                                        },
                                        {
                                            label: 'Åland Islands',
                                            value: 'Åland Islands'
                                        },
                                        {
                                            label: 'Albania',
                                            value: 'Albania'
                                        },
                                        {
                                            label: 'Algeria',
                                            value: 'Algeria'
                                        },
                                        {
                                            label: 'American Samoa',
                                            value: 'American Samoa'
                                        },
                                        {
                                            label: 'Andorra',
                                            value: 'Andorra'
                                        },
                                        {
                                            label: 'Angola',
                                            value: 'Angola'
                                        },
                                        {
                                            label: 'Anguilla',
                                            value: 'Anguilla'
                                        },
                                        {
                                            label: 'Antarctica',
                                            value: 'Antarctica'
                                        },
                                        {
                                            label: 'Antigua and Barbuda',
                                            value: 'Antigua and Barbuda'
                                        },
                                        {
                                            label: 'Argentina',
                                            value: 'Argentina'
                                        },
                                        {
                                            label: 'Armenia',
                                            value: 'Armenia'
                                        },
                                        {
                                            label: 'Aruba',
                                            value: 'Aruba'
                                        },
                                        {
                                            label: 'Australia',
                                            value: 'Australia'
                                        },
                                        {
                                            label: 'Austria',
                                            value: 'Austria'
                                        },
                                        {
                                            label: 'Azerbaijan',
                                            value: 'Azerbaijan'
                                        },
                                        {
                                            label: 'Bahamas',
                                            value: 'Bahamas'
                                        },
                                        {
                                            label: 'Bahrain',
                                            value: 'Bahrain'
                                        },
                                        {
                                            label: 'Bangladesh',
                                            value: 'Bangladesh'
                                        },
                                        {
                                            label: 'Barbados',
                                            value: 'Barbados'
                                        },
                                        {
                                            label: 'Belarus',
                                            value: 'Belarus'
                                        },
                                        {
                                            label: 'Belgium',
                                            value: 'Belgium'
                                        },
                                        {
                                            label: 'Belize',
                                            value: 'Belize'
                                        },
                                        {
                                            label: 'Benin',
                                            value: 'Benin'
                                        },
                                        {
                                            label: 'Bermuda',
                                            value: 'Bermuda'
                                        },
                                        {
                                            label: 'Bhutan',
                                            value: 'Bhutan'
                                        },
                                        {
                                            label: 'Bolivia',
                                            value: 'Bolivia'
                                        },
                                        {
                                            label: 'Bosnia and Herzegovina',
                                            value: 'Bosnia and Herzegovina',
                                        },
                                        {
                                            label: 'Botswana',
                                            value: 'Botswana'
                                        },
                                        {
                                            label: 'Bouvet Island',
                                            value: 'Bouvet Island'
                                        },
                                        {
                                            label: 'Brazil',
                                            value: 'Brazil'
                                        },
                                        {
                                            label: 'British Indian Ocean Territory',
                                            value: 'British Indian Ocean Territory',
                                        },
                                        {
                                            label: 'Brunei Darussalam',
                                            value: 'Brunei Darussalam'
                                        },
                                        {
                                            label: 'Bulgaria',
                                            value: 'Bulgaria'
                                        },
                                        {
                                            label: 'Burkina Faso',
                                            value: 'Burkina Faso'
                                        },
                                        {
                                            label: 'Burundi',
                                            value: 'Burundi'
                                        },
                                        {
                                            label: 'Cambodia',
                                            value: 'Cambodia'
                                        },
                                        {
                                            label: 'Cameroon',
                                            value: 'Cameroon'
                                        },
                                        {
                                            label: 'Canada',
                                            value: 'Canada'
                                        },
                                        {
                                            label: 'Cape Verde',
                                            value: 'Cape Verde'
                                        },
                                        {
                                            label: 'Cayman Islands',
                                            value: 'Cayman Islands'
                                        },
                                        {
                                            label: 'Central African Republic',
                                            value: 'Central African Republic',
                                        },
                                        {
                                            label: 'Chad',
                                            value: 'Chad'
                                        },
                                        {
                                            label: 'Chile',
                                            value: 'Chile'
                                        },
                                        {
                                            label: 'China',
                                            value: 'China'
                                        },
                                        {
                                            label: 'Christmas Island',
                                            value: 'Christmas Island'
                                        },
                                        {
                                            label: 'Cocos (Keeling) Islands',
                                            value: 'Cocos (Keeling) Islands',
                                        },
                                        {
                                            label: 'Colombia',
                                            value: 'Colombia'
                                        },
                                        {
                                            label: 'Comoros',
                                            value: 'Comoros'
                                        },
                                        {
                                            label: 'Congo',
                                            value: 'Congo'
                                        },
                                        {
                                            label: 'Congo, The Democratic Republic of The',
                                            value: 'Congo, The Democratic Republic of The',
                                        },
                                        {
                                            label: 'Cook Islands',
                                            value: 'Cook Islands'
                                        },
                                        {
                                            label: 'Costa Rica',
                                            value: 'Costa Rica'
                                        },
                                        {
                                            label: "Cote D'ivoire",
                                            value: "Cote D'ivoire"
                                        },
                                        {
                                            label: 'Croatia',
                                            value: 'Croatia'
                                        },
                                        {
                                            label: 'Cuba',
                                            value: 'Cuba'
                                        },
                                        {
                                            label: 'Cyprus',
                                            value: 'Cyprus'
                                        },
                                        {
                                            label: 'Czech Republic',
                                            value: 'Czech Republic'
                                        },
                                        {
                                            label: 'Denmark',
                                            value: 'Denmark'
                                        },
                                        {
                                            label: 'Djibouti',
                                            value: 'Djibouti'
                                        },
                                        {
                                            label: 'Dominica',
                                            value: 'Dominica'
                                        },
                                        {
                                            label: 'Dominican Republic',
                                            value: 'Dominican Republic'
                                        },
                                        {
                                            label: 'Ecuador',
                                            value: 'Ecuador'
                                        },
                                        {
                                            label: 'Egypt',
                                            value: 'Egypt'
                                        },
                                        {
                                            label: 'El Salvador',
                                            value: 'El Salvador'
                                        },
                                        {
                                            label: 'Equatorial Guinea',
                                            value: 'Equatorial Guinea'
                                        },
                                        {
                                            label: 'Eritrea',
                                            value: 'Eritrea'
                                        },
                                        {
                                            label: 'Estonia',
                                            value: 'Estonia'
                                        },
                                        {
                                            label: 'Ethiopia',
                                            value: 'Ethiopia'
                                        },
                                        {
                                            label: 'Falkland Islands (Malvinas)',
                                            value: 'Falkland Islands (Malvinas)',
                                        },
                                        {
                                            label: 'Faroe Islands',
                                            value: 'Faroe Islands'
                                        },
                                        {
                                            label: 'Fiji',
                                            value: 'Fiji'
                                        },
                                        {
                                            label: 'Finland',
                                            value: 'Finland'
                                        },
                                        {
                                            label: 'France',
                                            value: 'France'
                                        },
                                        {
                                            label: 'French Guiana',
                                            value: 'French Guiana'
                                        },
                                        {
                                            label: 'French Polynesia',
                                            value: 'French Polynesia'
                                        },
                                        {
                                            label: 'French Southern Territories',
                                            value: 'French Southern Territories',
                                        },
                                        {
                                            label: 'Gabon',
                                            value: 'Gabon'
                                        },
                                        {
                                            label: 'Gambia',
                                            value: 'Gambia'
                                        },
                                        {
                                            label: 'Georgia',
                                            value: 'Georgia'
                                        },
                                        {
                                            label: 'Germany',
                                            value: 'Germany'
                                        },
                                        {
                                            label: 'Ghana',
                                            value: 'Ghana'
                                        },
                                        {
                                            label: 'Gibraltar',
                                            value: 'Gibraltar'
                                        },
                                        {
                                            label: 'Greece',
                                            value: 'Greece'
                                        },
                                        {
                                            label: 'Greenland',
                                            value: 'Greenland'
                                        },
                                        {
                                            label: 'Grenada',
                                            value: 'Grenada'
                                        },
                                        {
                                            label: 'Guadeloupe',
                                            value: 'Guadeloupe'
                                        },
                                        {
                                            label: 'Guam',
                                            value: 'Guam'
                                        },
                                        {
                                            label: 'Guatemala',
                                            value: 'Guatemala'
                                        },
                                        {
                                            label: 'Guernsey',
                                            value: 'Guernsey'
                                        },
                                        {
                                            label: 'Guinea',
                                            value: 'Guinea'
                                        },
                                        {
                                            label: 'Guinea-bissau',
                                            value: 'Guinea-bissau'
                                        },
                                        {
                                            label: 'Guyana',
                                            value: 'Guyana'
                                        },
                                        {
                                            label: 'Haiti',
                                            value: 'Haiti'
                                        },
                                        {
                                            label: 'Heard Island and Mcdonald Islands',
                                            value: 'Heard Island and Mcdonald Islands',
                                        },
                                        {
                                            label: 'Holy See (Vatican City State)',
                                            value: 'Holy See (Vatican City State)',
                                        },
                                        {
                                            label: 'Honduras',
                                            value: 'Honduras'
                                        },
                                        {
                                            label: 'Hong Kong',
                                            value: 'Hong Kong'
                                        },
                                        {
                                            label: 'Hungary',
                                            value: 'Hungary'
                                        },
                                        {
                                            label: 'Iceland',
                                            value: 'Iceland'
                                        },
                                        {
                                            label: 'India',
                                            value: 'India'
                                        },
                                        {
                                            label: 'Indonesia',
                                            value: 'Indonesia'
                                        },
                                        {
                                            label: 'Iran, Islamic Republic of',
                                            value: 'Iran, Islamic Republic of',
                                        },
                                        {
                                            label: 'Iraq',
                                            value: 'Iraq'
                                        },
                                        {
                                            label: 'Ireland',
                                            value: 'Ireland'
                                        },
                                        {
                                            label: 'Isle of Man',
                                            value: 'Isle of Man'
                                        },
                                        {
                                            label: 'Israel',
                                            value: 'Israel'
                                        },
                                        {
                                            label: 'Italy',
                                            value: 'Italy'
                                        },
                                        {
                                            label: 'Jamaica',
                                            value: 'Jamaica'
                                        },
                                        {
                                            label: 'Japan',
                                            value: 'Japan'
                                        },
                                        {
                                            label: 'Jersey',
                                            value: 'Jersey'
                                        },
                                        {
                                            label: 'Jordan',
                                            value: 'Jordan'
                                        },
                                        {
                                            label: 'Kazakhstan',
                                            value: 'Kazakhstan'
                                        },
                                        {
                                            label: 'Kenya',
                                            value: 'Kenya'
                                        },
                                        {
                                            label: 'Kiribati',
                                            value: 'Kiribati'
                                        },
                                        {
                                            label: "Korea, Democratic People's Republic of",
                                            value: "Korea, Democratic People's Republic of",
                                        },
                                        {
                                            label: 'Korea, Republic of',
                                            value: 'Korea, Republic of'
                                        },
                                        {
                                            label: 'Kuwait',
                                            value: 'Kuwait'
                                        },
                                        {
                                            label: 'Kyrgyzstan',
                                            value: 'Kyrgyzstan'
                                        },
                                        {
                                            label: "Lao People's Democratic Republic",
                                            value: "Lao People's Democratic Republic",
                                        },
                                        {
                                            label: 'Latvia',
                                            value: 'Latvia'
                                        },
                                        {
                                            label: 'Lebanon',
                                            value: 'Lebanon'
                                        },
                                        {
                                            label: 'Lesotho',
                                            value: 'Lesotho'
                                        },
                                        {
                                            label: 'Liberia',
                                            value: 'Liberia'
                                        },
                                        {
                                            label: 'Libyan Arab Jamahiriya',
                                            value: 'Libyan Arab Jamahiriya',
                                        },
                                        {
                                            label: 'Liechtenstein',
                                            value: 'Liechtenstein'
                                        },
                                        {
                                            label: 'Lithuania',
                                            value: 'Lithuania'
                                        },
                                        {
                                            label: 'Luxembourg',
                                            value: 'Luxembourg'
                                        },
                                        {
                                            label: 'Macao',
                                            value: 'Macao'
                                        },
                                        {
                                            label: 'Macedonia, The Former Yugoslav Republic of',
                                            value: 'Macedonia, The Former Yugoslav Republic of',
                                        },
                                        {
                                            label: 'Madagascar',
                                            value: 'Madagascar'
                                        },
                                        {
                                            label: 'Malawi',
                                            value: 'Malawi'
                                        },
                                        {
                                            label: 'Malaysia',
                                            value: 'Malaysia'
                                        },
                                        {
                                            label: 'Maldives',
                                            value: 'Maldives'
                                        },
                                        {
                                            label: 'Mali',
                                            value: 'Mali'
                                        },
                                        {
                                            label: 'Malta',
                                            value: 'Malta'
                                        },
                                        {
                                            label: 'Marshall Islands',
                                            value: 'Marshall Islands'
                                        },
                                        {
                                            label: 'Martinique',
                                            value: 'Martinique'
                                        },
                                        {
                                            label: 'Mauritania',
                                            value: 'Mauritania'
                                        },
                                        {
                                            label: 'Mauritius',
                                            value: 'Mauritius'
                                        },
                                        {
                                            label: 'Mayotte',
                                            value: 'Mayotte'
                                        },
                                        {
                                            label: 'Mexico',
                                            value: 'Mexico'
                                        },
                                        {
                                            label: 'Micronesia, Federated States of',
                                            value: 'Micronesia, Federated States of',
                                        },
                                        {
                                            label: 'Moldova, Republic of',
                                            value: 'Moldova, Republic of'
                                        },
                                        {
                                            label: 'Monaco',
                                            value: 'Monaco'
                                        },
                                        {
                                            label: 'Mongolia',
                                            value: 'Mongolia'
                                        },
                                        {
                                            label: 'Montenegro',
                                            value: 'Montenegro'
                                        },
                                        {
                                            label: 'Montserrat',
                                            value: 'Montserrat'
                                        },
                                        {
                                            label: 'Morocco',
                                            value: 'Morocco'
                                        },
                                        {
                                            label: 'Mozambique',
                                            value: 'Mozambique'
                                        },
                                        {
                                            label: 'Myanmar',
                                            value: 'Myanmar'
                                        },
                                        {
                                            label: 'Namibia',
                                            value: 'Namibia'
                                        },
                                        {
                                            label: 'Nauru',
                                            value: 'Nauru'
                                        },
                                        {
                                            label: 'Nepal',
                                            value: 'Nepal'
                                        },
                                        {
                                            label: 'Netherlands',
                                            value: 'Netherlands'
                                        },
                                        {
                                            label: 'Netherlands Antilles',
                                            value: 'Netherlands Antilles'
                                        },
                                        {
                                            label: 'New Caledonia',
                                            value: 'New Caledonia'
                                        },
                                        {
                                            label: 'New Zealand',
                                            value: 'New Zealand'
                                        },
                                        {
                                            label: 'Nicaragua',
                                            value: 'Nicaragua'
                                        },
                                        {
                                            label: 'Niger',
                                            value: 'Niger'
                                        },
                                        {
                                            label: 'Nigeria',
                                            value: 'Nigeria'
                                        },
                                        {
                                            label: 'Niue',
                                            value: 'Niue'
                                        },
                                        {
                                            label: 'Norfolk Island',
                                            value: 'Norfolk Island'
                                        },
                                        {
                                            label: 'Northern Mariana Islands',
                                            value: 'Northern Mariana Islands',
                                        },
                                        {
                                            label: 'Norway',
                                            value: 'Norway'
                                        },
                                        {
                                            label: 'Oman',
                                            value: 'Oman'
                                        },
                                        {
                                            label: 'Pakistan',
                                            value: 'Pakistan'
                                        },
                                        {
                                            label: 'Palau',
                                            value: 'Palau'
                                        },
                                        {
                                            label: 'Palestinian Territory, Occupied',
                                            value: 'Palestinian Territory, Occupied',
                                        },
                                        {
                                            label: 'Panama',
                                            value: 'Panama'
                                        },
                                        {
                                            label: 'Papua New Guinea',
                                            value: 'Papua New Guinea'
                                        },
                                        {
                                            label: 'Paraguay',
                                            value: 'Paraguay'
                                        },
                                        {
                                            label: 'Peru',
                                            value: 'Peru'
                                        },
                                        {
                                            label: 'Philippines',
                                            value: 'Philippines'
                                        },
                                        {
                                            label: 'Pitcairn',
                                            value: 'Pitcairn'
                                        },
                                        {
                                            label: 'Poland',
                                            value: 'Poland'
                                        },
                                        {
                                            label: 'Portugal',
                                            value: 'Portugal'
                                        },
                                        {
                                            label: 'Puerto Rico',
                                            value: 'Puerto Rico'
                                        },
                                        {
                                            label: 'Qatar',
                                            value: 'Qatar'
                                        },
                                        {
                                            label: 'Reunion',
                                            value: 'Reunion'
                                        },
                                        {
                                            label: 'Romania',
                                            value: 'Romania'
                                        },
                                        {
                                            label: 'Russian Federation',
                                            value: 'Russian Federation'
                                        },
                                        {
                                            label: 'Rwanda',
                                            value: 'Rwanda'
                                        },
                                        {
                                            label: 'Saint Helena',
                                            value: 'Saint Helena'
                                        },
                                        {
                                            label: 'Saint Kitts and Nevis',
                                            value: 'Saint Kitts and Nevis',
                                        },
                                        {
                                            label: 'Saint Lucia',
                                            value: 'Saint Lucia'
                                        },
                                        {
                                            label: 'Saint Pierre and Miquelon',
                                            value: 'Saint Pierre and Miquelon',
                                        },
                                        {
                                            label: 'Saint Vincent and The Grenadines',
                                            value: 'Saint Vincent and The Grenadines',
                                        },
                                        {
                                            label: 'Samoa',
                                            value: 'Samoa'
                                        },
                                        {
                                            label: 'San Marino',
                                            value: 'San Marino'
                                        },
                                        {
                                            label: 'Sao Tome and Principe',
                                            value: 'Sao Tome and Principe',
                                        },
                                        {
                                            label: 'Saudi Arabia',
                                            value: 'Saudi Arabia'
                                        },
                                        {
                                            label: 'Senegal',
                                            value: 'Senegal'
                                        },
                                        {
                                            label: 'Serbia',
                                            value: 'Serbia'
                                        },
                                        {
                                            label: 'Seychelles',
                                            value: 'Seychelles'
                                        },
                                        {
                                            label: 'Sierra Leone',
                                            value: 'Sierra Leone'
                                        },
                                        {
                                            label: 'Singapore',
                                            value: 'Singapore'
                                        },
                                        {
                                            label: 'Slovakia',
                                            value: 'Slovakia'
                                        },
                                        {
                                            label: 'Slovenia',
                                            value: 'Slovenia'
                                        },
                                        {
                                            label: 'Solomon Islands',
                                            value: 'Solomon Islands'
                                        },
                                        {
                                            label: 'Somalia',
                                            value: 'Somalia'
                                        },
                                        {
                                            label: 'South Africa',
                                            value: 'South Africa'
                                        },
                                        {
                                            label: 'South Georgia and The South Sandwich Islands',
                                            value: 'South Georgia and The South Sandwich Islands',
                                        },
                                        {
                                            label: 'Spain',
                                            value: 'Spain'
                                        },
                                        {
                                            label: 'Sri Lanka',
                                            value: 'Sri Lanka'
                                        },
                                        {
                                            label: 'Sudan',
                                            value: 'Sudan'
                                        },
                                        {
                                            label: 'Suriname',
                                            value: 'Suriname'
                                        },
                                        {
                                            label: 'Svalbard and Jan Mayen',
                                            value: 'Svalbard and Jan Mayen',
                                        },
                                        {
                                            label: 'Swaziland',
                                            value: 'Swaziland'
                                        },
                                        {
                                            label: 'Sweden',
                                            value: 'Sweden'
                                        },
                                        {
                                            label: 'Switzerland',
                                            value: 'Switzerland'
                                        },
                                        {
                                            label: 'Syrian Arab Republic',
                                            value: 'Syrian Arab Republic'
                                        },
                                        {
                                            label: 'Taiwan',
                                            value: 'Taiwan'
                                        },
                                        {
                                            label: 'Tajikistan',
                                            value: 'Tajikistan'
                                        },
                                        {
                                            label: 'Tanzania, United Republic of',
                                            value: 'Tanzania, United Republic of',
                                        },
                                        {
                                            label: 'Thailand',
                                            value: 'Thailand'
                                        },
                                        {
                                            label: 'Timor-leste',
                                            value: 'Timor-leste'
                                        },
                                        {
                                            label: 'Togo',
                                            value: 'Togo'
                                        },
                                        {
                                            label: 'Tokelau',
                                            value: 'Tokelau'
                                        },
                                        {
                                            label: 'Tonga',
                                            value: 'Tonga'
                                        },
                                        {
                                            label: 'Trinidad and Tobago',
                                            value: 'Trinidad and Tobago'
                                        },
                                        {
                                            label: 'Tunisia',
                                            value: 'Tunisia'
                                        },
                                        {
                                            label: 'Turkey',
                                            value: 'Turkey'
                                        },
                                        {
                                            label: 'Turkmenistan',
                                            value: 'Turkmenistan'
                                        },
                                        {
                                            label: 'Turks and Caicos Islands',
                                            value: 'Turks and Caicos Islands',
                                        },
                                        {
                                            label: 'Tuvalu',
                                            value: 'Tuvalu'
                                        },
                                        {
                                            label: 'Uganda',
                                            value: 'Uganda'
                                        },
                                        {
                                            label: 'Ukraine',
                                            value: 'Ukraine'
                                        },
                                        {
                                            label: 'United Arab Emirates',
                                            value: 'United Arab Emirates'
                                        },
                                        {
                                            label: 'United Kingdom',
                                            value: 'United Kingdom'
                                        },
                                        {
                                            label: 'United States',
                                            value: 'United States'
                                        },
                                        {
                                            label: 'United States Minor Outlying Islands',
                                            value: 'United States Minor Outlying Islands',
                                        },
                                        {
                                            label: 'Uruguay',
                                            value: 'Uruguay'
                                        },
                                        {
                                            label: 'Uzbekistan',
                                            value: 'Uzbekistan'
                                        },
                                        {
                                            label: 'Vanuatu',
                                            value: 'Vanuatu'
                                        },
                                        {
                                            label: 'Venezuela',
                                            value: 'Venezuela'
                                        },
                                        {
                                            label: 'Viet Nam',
                                            value: 'Viet Nam'
                                        },
                                        {
                                            label: 'Virgin Islands, British',
                                            value: 'Virgin Islands, British',
                                        },
                                        {
                                            label: 'Virgin Islands, U.S.',
                                            value: 'Virgin Islands, U.S.'
                                        },
                                        {
                                            label: 'Wallis and Futuna',
                                            value: 'Wallis and Futuna'
                                        },
                                        {
                                            label: 'Western Sahara',
                                            value: 'Western Sahara'
                                        },
                                        {
                                            label: 'Yemen',
                                            value: 'Yemen'
                                        },
                                        {
                                            label: 'Zambia',
                                            value: 'Zambia'
                                        },
                                        {
                                            label: 'Zimbabwe',
                                            value: 'Zimbabwe'
                                        },
                                    ]}
                                    error={errors.country}
                                    title={'Z jakiego kraju pochodzisz?'}
                                />
                                <LabeledSelect
                                    label='Województwo'
                                    register={register}
                                    name='voivodeship'
                                    options={[
                                        {
                                            label: 'Dolnośląskie',
                                            value: 'Dolnośląskie'
                                        },
                                        {
                                            label: 'Kujawsko-pomorskie',
                                            value: 'Kujawsko-pomorskie'
                                        },
                                        {
                                            label: 'Lubelskie',
                                            value: 'Lubelskie'
                                        },
                                        {
                                            label: 'Lubuskie',
                                            value: 'Lubuskie'
                                        },
                                        {
                                            label: 'Łódzkie',
                                            value: 'Łódzkie'
                                        },
                                        {
                                            label: 'Małopolskie',
                                            value: 'Małopolskie'
                                        },
                                        {
                                            label: 'Mazowieckie',
                                            value: 'Mazowieckie'
                                        },
                                        {
                                            label: 'Opolskie',
                                            value: 'Opolskie'
                                        },
                                        {
                                            label: 'Podkarpackie',
                                            value: 'Podkarpackie'
                                        },
                                        {
                                            label: 'Podlaskie',
                                            value: 'Podlaskie'
                                        },
                                        {
                                            label: 'Pomorskie',
                                            value: 'Pomorskie'
                                        },
                                        {
                                            label: 'Śląskie',
                                            value: 'Śląskie'
                                        },
                                        {
                                            label: 'Świętokrzyskie',
                                            value: 'Świętokrzyskie'
                                        },
                                        {
                                            label: 'Warmińsko-mazurskie',
                                            value: 'Warmińsko-mazurskie'
                                        },
                                        {
                                            label: 'Wielkopolskie',
                                            value: 'Wielkopolskie'
                                        },
                                        {
                                            label: 'Zachodniopomorskie',
                                            value: 'Zachodniopomorskie'
                                        },
                                    ]}
                                    error={errors.voivodeship}
                                    title={'Z jakiego województwa pochodzisz?'}
                                />
                            </div>
                            <div className="grid grid-cols-1 gap-5 mt-8">
                                <button
                                    disabled={isSubmitting}
                                    className='py-3 px-6 font-bold rounded bg-blue-400 hover:bg-blue-500 text-white duration-300'
                                    type={"submit"}
                                    aria-label='Zapisz'
                                >
                                    Zapisz
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    );
}
