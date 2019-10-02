var app=(()=>{
    return{
        init:(ctx)=>{

        	playerService.login(ctx);
        	playerService.moveJoin();
        	home.login(ctx);
        	playerJoin.join(ctx);

            $('#a_position').click(()=>{
            	alert('a_positisssssson');
            	location.assign("player.do?action=search&page=main&searchCode=2_positions") 
            });
            $('#back_page').click(()=>{
            	alert('백페이지 이동');
            	location.assign("facade.do?action=MOVE&page=facade") 
            });
            $('#back_page_search').click(()=>{
            	alert('백페이지 이동');
            	location.assign("player.do?action=MOVE&page=main") 
            });
            $('#4_find_by_teamid_position').click(()=>{
				$('#04').submit();	
            });
            $('#5_find_by_teamid_height_name').click(()=>{
				$('#05').submit();	
            });
            
        }
    };
})();

var user=(()=>{
	var _playerId, _playerName, _teamId, _ePlayerName, _nickname, _joinYyyy, _position, _backNo, _nation, _birthDate, _solar, _height, _weight;
	var setPlayerId = (playerId)=>{this._playerId = playerId;}
	var setSolar = (solar) => {this._solar = solar;}
	var getPlayerId = ()=>{return this._playerId;}
	var getSolar = ()=>{return this._solar;}
	return{
	'setPlayerId' :  setPlayerId,
	'setSolar' : setSolar ,
	'getPlayerId' : getPlayerId ,
	'getSolar' : getSolar 
	};
})();
	
var playerService = (()=>{
	return {
		login: (ctx)=>{
			$('#login_btn').click(()=>{
				if($('#playerId').val()===''){
					alert('ID값이 없습니다');
				}else if($('#solar').val()===''){
					alert('password값이 없습니다');
				}else{
					alert("입력한 아이디 / 비번: " + $('#playerId').val()+ " / "+$('#solar').val());
					$('#login_form').attr('action', ctx+'/facade.do' );
					$('#login_form').attr('method', 'POST' );
					$('#login_form').submit();	
				}
			});
		},
		moveJoin: ()=>{
	          $('#a_join').click(()=>{
	            	alert('회원가입 이동');
	            	location.assign("facade.do?action=MOVE&page=join") 
	       });
		}
		
	};	
})();

var home=(()=>{
    return{
    	login: ()=>{
			$('#4_find_by_teamid_position').click(()=>{
				alert("ddd");
					$('#04').submit();	
			});
	}
    };
})();

var playerJoin = (()=>{
	return {
		join: (ctx)=>{
			$('#join_submit').click(()=>{
				if($('#playerId').val()===''){
					alert('ID값이 없습니다');
				}else if($('#solar').val()===''){
					alert('password값이 없습니다');
				}else{
					$('#join_form').attr('action', ctx+ '/player.do' );
					$('#join_form').attr('method', 'POST' );
					$('#join_form').submit();	
				}
			});
	}
};	
})();


