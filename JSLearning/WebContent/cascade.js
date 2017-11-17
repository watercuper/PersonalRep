var data=[
		{id:1,
		 name:"湖南",
		 cities:[
				{id:11,name:"长沙"},
				{id:12,name:"岳阳"},
				{id:13,name:"衡阳"},
				{id:14,name:"益阳"}
			]
		},
		{id:2,
	     name:"湖北",
	     cities:[
				{id:21,name:"武汉"},
				{id:22,name:"鄂州"},
				{id:23,name:"沙市"},
				{id:24,name:"荆州"}
			]
		},
		{id:3,
		name:"江西",
		cities:[
				{id:31,name:"南昌"},
				{id:32,name:"鹰潭"},
				{id:33,name:"九江"},
				{id:34,name:"上饶"}
			]
		},
		{id:4,
		name:"安徽",
		cities:[
				{id:41,name:"合肥"},
				{id:42,name:"芜湖"},
				{id:43,name:"安庆"},
				{id:44,name:"铜陵"}
			]
		},
];

var province=document.getElementById("province");
var cities=document.getElementById("cities");

province.innerHTML="";

for(var i=0,len=data.length;i<len;i++){
	var op=document.createElement("option");
	op.value=data[i].id;
	op.innerHTML=data[i].name;
	province.appendChild(op);
}

province.onchange=function(){
	cities.innerHTML="";
	var proId=province.value;
	for(var i=0,len=data.length;i<len;i++){
		if(data[i].id==proId){
			var cityData=data[i].cities;
			for(var i=0,len=cityData.length;i<len;i++){
				var op=document.createElement("option");
				op.value=cityData[i].id;
				op.innerHTML=cityData[i].name;
				cities.appendChild(op);
			}
			break;
		}
	}
};

