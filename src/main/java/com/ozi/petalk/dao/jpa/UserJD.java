package com.ozi.petalk.dao.jpa;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.User;
@Repository
public interface UserJD extends JpaRepository<User, Long> {
	@Query(value = "select email from ptdb_dev.sbmain.users u where u.email = ?1", nativeQuery = true)
	Optional<User> findByEmail(String username);
//	public Optional<ArtistSP> getArtistById(Long id);
//	public Optional<ArtistSP> getArtistById(String id);
//	@Query(value="SELECT * FROM artistsp WHERE artist_name = :string", nativeQuery = true)
//	public ArtistSP getArtistFromName(String string);
//	
//	@Query(value="SELECT * FROM artistsp WHERE artist_name = :artistName", nativeQuery = true)
//	Optional<ArtistSP> existByArtistName(String artistName );
}
