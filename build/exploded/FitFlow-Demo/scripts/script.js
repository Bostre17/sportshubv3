// JavaScript per il calendario
document.addEventListener('DOMContentLoaded', function () {
    const calendar = document.getElementById('calendar');

    function createCalendar(year, month) {
        const monthNames = ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"];
        const daysInMonth = new Date(year, month + 1, 0).getDate();
        const firstDay = new Date(year, month, 1).getDay();
        
        let html = `<h3>${monthNames[month]} ${year}</h3><table><tr>`;
        
        // Intestazione dei giorni della settimana
        const weekDays = ["Dom", "Lun", "Mar", "Mer", "Gio", "Ven", "Sab"];
        weekDays.forEach(day => {
            html += `<th>${day}</th>`;
        });
        
        html += `</tr><tr>`;
        
        // Riempimento del calendario
        let dayCount = 1;
        for (let i = 0; i < 42; i++) {
            if (i < firstDay || dayCount > daysInMonth) {
                html += `<td></td>`;
            } else {
                html += `<td>${dayCount}</td>`;
                dayCount++;
            }
            
            if (i === 6 || i === 13 || i === 20 || i === 27 || i === 34) {
                html += `</tr><tr>`;
            }
        }
        
        html += `</tr></table>`;
        calendar.innerHTML = html;
    }
    
    createCalendar(2023, 8); // Inizialmente mostra il calendario per settembre 2023
});

// JavaScript per il menu a tendina
document.addEventListener('DOMContentLoaded', function () {
    const dropdownMenu = document.getElementById('dropdown-menu');

    // Aggiungi un gestore per l'evento change del menu a tendina
    dropdownMenu.addEventListener('change', function () {
        const selectedOption = dropdownMenu.options[dropdownMenu.selectedIndex].value;
        
        // Esegui l'azione desiderata in base all'opzione selezionata
        if (selectedOption === 'Opzione 1') {
            // Codice per l'opzione 1
        } else if (selectedOption === 'Opzione 2') {
            // Codice per l'opzione 2
        } else if (selectedOption === 'Opzione 3') {
            // Codice per l'opzione 3
        }
        // Aggiungi altre condizioni per le opzioni aggiuntive se necessario
    });
});