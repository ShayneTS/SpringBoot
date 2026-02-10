document.addEventListener('DOMContentLoaded', funciton() {
  var coinFilter = document.getElementById('coinSearch');
  var coinRows = document.querySelectorAll('.coinRow');

  console.log('Debug coin-search.js');
  

  coinFilter.addEventListener('input', funciton() {
    var filterValue = coinFilter.value.toUpperCase();
    coinRows.forEach(function(row) {
      var coinName = row.querySelector('td:nth-child(1)').textContent.toUpperCase();
      if (coinName.indexOf(filterValue) > -1) {
        row.style.display = '';
      } else{
        row.style.display = 'none';
      }
    });
  })
})