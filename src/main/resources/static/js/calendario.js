document.addEventListener('DOMContentLoaded', function() {
    let calendarEl = document.getElementById('calendario');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        width: '95%',
        "locale": 'pt-br', // Define o idioma do calendário
        "initialView": 'dayGridMonth', // Define a visualização inicial, nesse caso é a view de mês
        dateClick: function(info) {
            alert('Clicked on: ' + info.dateStr); // Exibe um alerta com a data clicada
        },
        "headerToolbar": { // Controla os botões de navegação presentes na barra superior
            "center": 'multiMonthYear,dayGridMonth,timeGridWeek,timeGridDay,listWeek' // Indica que os botões de navegação serão centralizados
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
    });
    calendar.render();
});