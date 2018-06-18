<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<a href="logout.jsp">logout</a>
<h1> ${message1} !!! </h1>
<h3 align="center">Arenas to book</h3>

<div id = "destination" class="container" *ngIf="hotelList">
    <div class="row"  *ngFor="let hotels of hotelList | paginate: { itemsPerPage: 5, currentPage: p }">
        <div class = "col-md-6">
          <ul>
            <li class="listHotels">
                <a href="javascript:void(0);" (click)="onSelect(hotels)"><h2>{{hotels.name}}</h2></a>
                <img [src]="hotels.photos | SanitizeHtmlPipe" class="imageSize">
                <br>
                Location: {{hotels.location}}
                <br>  
                Services: {{hotels.services}}
                <br> 
                
                <br>
            </li>
          </ul>
        </div>
        <div class = "col-md-2">
            <br><br>
        <form (click) = "addToWishList(hotels.name)" *ngIf="userName">
                  
            <input type="button" class="btn btn-outline-secondary" value="WishList">
          </form>  
          <br><br>
        </div>
        
         
          <div class = "col-md-2" *ngIf="access">
              <br><br>
            <input type="button" (click)= "deleteHotel(hotels._id)" value ="Delete" class="btn btn-outline-danger">
          <br><br>
          </div>
  
          <div class = "col-md-2" *ngIf="access">
              <br><br>
              <input type="button" (click)= "updateHotels(hotels._id)" value ="Update" class="btn btn-outline-danger">
            <br><br>
          </div>
          
            
    
  </div>
</body>
</html>