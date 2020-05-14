Func _UploadFile($file)
	AutoItSetOption("WinTitleMatchMode", 2)
	WinWaitActive("","File &name", 15);
	ControlSetText("", "File &name", "[CLASS:Edit; INSTANCE:1]", $file);
	ControlClick("", "File &name","[CLASS:Button; TEXT:&Open]");
EndFunc
_UploadFile($CmdLine[$CmdLine[0]])