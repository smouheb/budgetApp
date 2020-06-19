/**
 * 
 */

 var ctx = document.getElementById('myChart');
		  var myChart = new Chart(ctx, {
		      type: 'pie',
		      data: {
		          labels: ['Red', 'Blue', 'Green'],
		          datasets: [{
		              label: '# of Votes',
		              data: [ 10, 10, 10],
		              backgroundColor: [
		                  'rgba(54, 162, 235, 0.2)',
		                  'rgba(255, 206, 86, 0.2)',
		                  'rgba(153, 102, 255, 0.2)'
		              ],
		              borderColor: [
		                  'rgba(54, 162, 235, 1)',
		                  'rgba(255, 206, 86, 1)',
		                  'rgba(153, 102, 255, 1)'
		              ],
		              borderWidth: 1
		          }]
		      }
		  });