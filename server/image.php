<?php

class Image{
	
	private $conn;
	private $table_name = "images";
	
	public $id;
	public $path;
	public $created;
	
	public function __construct($db){
		$this->conn = $db;
	}
	
	function create(){
		// query to insert record
    $query = "INSERT INTO
                " . $this->table_name . "
            SET
                path=:path, created=:created";
 
    // prepare query
    $stmt = $this->conn->prepare($query);
	
	$this->path=htmlspecialchars(strip_tags($this->path));
	$this->created=htmlspecialchars(strip_tags($this->created));
	
	$stmt->bindParam(":path", $this->path);
	$stmt->bindParam(":created", $this->created);
	
	if($stmt->execute()){
		return true;
	}
	return false;
	
}

}

?>