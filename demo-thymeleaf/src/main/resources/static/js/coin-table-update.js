$(document).ready(function(){
  setInterval(function() {
    $ajax({
      url: '/refresh', //prepare API to call for refresh
      type: 'GET',
      success: function(data) {
        console.log(data);
        // assume data is a list
        data.forEach(function(coin, index){
          var row = $(`tr[data-coin-id='${coin.id}']`);
          if (row.length){
            row.find("td:nth-child(3)").text("$" + coin.current_price.toFixed(2));
            row.find("td:nth-child(5)").text("$" + coin.market_cap);

            var priceClass = Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
              ? "neutral"
              : coin.price_change_percentage_24h < 0
              ? "down"
              ? "up";

            var priceChangeIcon = 
              Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
                ? ""
                : coin.price_change_percentage_24h < 0
                ? "▼"
                : "▲";

            var priceChangeValue =
              Math.abs(coin.price_change_percentage_24h).toFixed(2) + "%";

            var priceChangeElement = row.find(".price-change");
            priceChangeElement.removeClass("up down neutral").addClass(priceClass).html(`${priceChangeIcon} ${priceChangeValue}`)
          }
        });
        error: function(err) {
          console.error("Error Fetching updated coin data:", err);
        }
      },

    });
  }, 30000);
});