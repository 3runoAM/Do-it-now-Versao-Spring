$(document).ready(function() {
    // Seleciona o elemento que será o container do calendário
    let calendarEl = document.getElementById('calendario');
    // Instancia o calendário e define as configurações
    let calendar = new FullCalendar.Calendar(calendarEl, {
        "height": '90%',
        "locale": 'pt-br', // Define o idioma do calendário
        "initialView": 'dayGridMonth', // Define a visualização inicial, nesse caso é a view de mês
        dateClick: function(info) {
            alert('Clicked on: ' + info.dateStr); // Exibe um alerta com a data clicada
        },
        "headerToolbar": { // Controla os botões de navegação presentes na barra superior
            // Indica que os botões de navegação serão centralizados
            "center": 'multiMonthYear,dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        "buttonText": { // Define os textos dos botões de navegação
            "today": 'Hoje',
            "year": 'Ano',
            "month": 'Mês',
            "week": 'Semana',
            "day": 'Dia',
            "list": 'Listagem'
        },
        "navLinks": true, // Se true, os dias com eventos serão clicáveis
        "weekNumbers": true, // Se true, os números das semanas serão exibidos
        "weekText": '', // Define o texto que será exibido antes do número da semana
        "eventLimit": true, // Se true, um link "mais" será exibido quando houver muitos eventos em um dia
        "selectable": true, // Se true, o usuário poderá selecionar um período do calendário
        "selectOverlap": true, // Se true, o usuário poderá selecionar um período que já tenha um evento
        "nowIndicator": true, // Se true, uma linha vertical será exibida na data atual
        "eventSources": [
            // your event source
            {
                events: [ // put the array in the `events` property
                    {
                        title  : 'event1',
                        start  : '2024-01-01'
                    },
                    {
                        title  : 'event2',
                        start  : '2024-01-05',
                        end    : '2024-01-07'
                    },
                    {
                        title  : 'event3',
                        start  : '2024-01-09T12:30:00',
                    }
                ],
                color: 'black',     // an option!
                textColor: 'yellow' // an option!
            }],
        // "events": [
        //     {
        //         title  : 'event1',
        //         start  : '2024-01-01'
        //     },
        //     {
        //         title  : 'event2',
        //         start  : '2024-01-05',
        //         end    : '2024-01-07',
        //         allDay : true // will make the time show
        //     },
        //     {
        //         title  : 'event3',
        //         start  : '2024-01-09T12:30:00',
        //         allDay : false // will make the time show
        //     },
        // ]
        // "select": function(info) {
        //     alert('Selected ' + info.startStr + ' to ' + info.endStr); // Exibe um alerta com o período selecionado
        // },
        // "unselect": function(info) {
        //     alert('Unselected ' + info.startStr + ' to ' + info.endStr); // Exibe um alerta com o período desselecionado
        // }
    });
    calendar.render();
});
