package com.ozi.petalk.dao.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.User;
@Repository
public interface UserJD extends JpaRepository<User, Long> {
//	public Optional<ArtistSP> getArtistById(Long id);
//	public Optional<ArtistSP> getArtistById(String id);
//	@Query(value="SELECT * FROM artistsp WHERE artist_name = :string", nativeQuery = true)
//	public ArtistSP getArtistFromName(String string);
//	
//	@Query(value="SELECT * FROM artistsp WHERE artist_name = :artistName", nativeQuery = true)
//	Optional<ArtistSP> existByArtistName(String artistName );
}
