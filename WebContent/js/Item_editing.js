var vGoTop = {};
function goTop(){
 
  vGoTop["coef"] = 50;  // ←滑らか係数（大きいほど滑らか）
  vGoTop["cnt"]  = 0;
 
  // --- 現在のスクロール位置取得 -----
  var startX = document.body.scrollLeft || document.documentElement.scrollLeft;
  var startY = document.body.scrollTop  || document.documentElement.scrollTop;
 
  // --- スクロールの単位計算 ---------
  var moveSplitCnt = 0;
  for(var i = 1; i <= vGoTop["coef"]; i++) {
    moveSplitCnt += i * i;
  }
  vGoTop["unitH"] = startY / ( moveSplitCnt * 2 );
 
  vGoTop["nextX"] = startX;
  vGoTop["nextY"] = startY;
 
  // --- スクロール開始 ---------------
  goTopLoop();
}
function goTopLoop(){
 // ============================================================================
 //  スクロール実行
 // ============================================================================
 
  vGoTop["cnt"]++;
 
  // --- 次のスクロール位置計算 -------
  var Coef = 0;
  if(vGoTop["cnt"] <= vGoTop["coef"]){
    Coef = vGoTop["cnt"];
  }else{
    Coef = ((vGoTop["coef"] * 2) + 1) - vGoTop["cnt"];
  }
  vGoTop["nextY"] = vGoTop["nextY"] - Math.round( vGoTop["unitH"] * ( Coef * Coef) );
  if((vGoTop["cnt"] >= (vGoTop["coef"] * 2))||(vGoTop["nextY"] <= 0)){
    vGoTop["nextY"] = 0;
  }
 
  // --- スクロール実行 ---------------
  window.scrollTo(vGoTop["nextX"], vGoTop["nextY"]);
 
  // --- 次のスクロールを設定 ---------
  if(vGoTop["nextY"] <= 0){
    clearTimeout(vGoTop["timer"]);                   // 終了：タイマクリア
  }else{
    vGoTop["timer"] = setTimeout("goTopLoop()",10);  // 次のループ
  }
}