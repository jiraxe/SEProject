$('#infoTable').on('click', 'tbody tr', function(event) {
    $(this).addClass('highlight').siblings().removeClass('highlight');
    console.log("hi");
});

console.log("here");