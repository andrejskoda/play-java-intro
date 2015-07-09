$ ->
  $.get "/offices", (offices) ->
    $.each offices, (index, office) ->
      $("#officess").append $("<li>").text office.name