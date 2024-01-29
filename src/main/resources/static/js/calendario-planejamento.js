document.addEventListener('DOMContentLoaded', function() {
    // Seleciona o elemento que será o container do calendário
    let calendarEl = document.getElementById('calendario-planejamento');

    // Instancia o calendário e define as configurações
    let calendar = new FullCalendar.Calendar(calendarEl, {
        "width": '50%',
        "locale": 'pt-br',
        "initialView": 'timeGridDay',
        "nowIndicator": true,
    });
    calendar.render();
});