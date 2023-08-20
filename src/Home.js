import React, { useState } from "react";
import {
  View,
  Text,
  StyleSheet,
  TouchableOpacity,
  TextInput,
  Image,
  FlatList,
} from "react-native";
import { useNavigation } from "@react-navigation/native";
import { LinearGradient } from "expo-linear-gradient";
import { Ionicons } from "@expo/vector-icons";
import { locations } from "./Card";
import Information from './Information';

const Home = () => {
  const navigation = useNavigation();
  const [city, setCity] = useState("");
  const [suggestions, setSuggestions] = useState([]);

  const handleSearch = () => {
    const foundLocation = locations.find(item => item.name === city);
    if (foundLocation) {
      navigation.navigate("Information", { name: city, image: foundLocation.image });
      setCity(""); 
      setSuggestions([]);
    } else {
      alert("Image not found for the selected city.");
    }
  };

  const handleInputChange = (inputText) => {
    setCity(inputText);
    const matchedSuggestions = locations
      .filter(item => item.name.toLowerCase().includes(inputText.toLowerCase()))
      .map(item => item.name);
    setSuggestions(matchedSuggestions);
  };

  const handleLocationPress = (item) => {
    navigation.navigate("Information", { name: item.name, image: item.image });
  };

  const renderLocationItem = ({ item }) => (
    <TouchableOpacity
      style={styles.locationItemContainer}
      onPress={() => handleLocationPress(item)}
    >
      <Image source={item.image} style={styles.locationImage} />
      <Text style={styles.locationText}>{item.name}</Text>
    </TouchableOpacity>
  );

  return (
    <LinearGradient
      colors={['#2A5470', '#4C4177']}
      style={styles.container}
    >
      <TouchableOpacity
        style={styles.hamburgerIcon}
        onPress={() => {
          // Add your navigation logic here
        }}
      >
        <Ionicons name="menu" size={35} color="white" />
      </TouchableOpacity>

      <TouchableOpacity
        style={styles.avatarIcon}
        onPress={() => {
          // Add your navigation logic here
        }}
      >
        <Image
          style={styles.tinyLogo}
          source={require("../assets/Images/avater.png")}
        />
      </TouchableOpacity>

        <View style={styles.searchContainer}>
          <TextInput
            style={styles.searchinput}
            placeholder="Search by city..."
            onChangeText={handleInputChange}
            value={city}
          />
          <TouchableOpacity
            onPress={handleSearch}
            style={styles.searchicon}
            activeOpacity={0.8}
          >
            <Ionicons name="search" size={24} color="white" />
          </TouchableOpacity>
        </View>
        {suggestions.length > 0 && (
          <View style={styles.suggestionsContainer}>
            {suggestions.map((item, index) => (
              <TouchableOpacity
                key={index}
                style={styles.suggestionItem}
                onPress={() => setCity(item)}
              >
                <Text style={styles.suggestionText}>{item}</Text>
              </TouchableOpacity>
            ))}
          </View>
        )}
   

      <View style={styles.locationsContainer}>
        <Text style={styles.text2}>Locations</Text>
        <FlatList
          data={locations}
          renderItem={renderLocationItem}
          keyExtractor={(item, index) => index.toString()}
        />
      </View>
    </LinearGradient>
  );
};
const styles = StyleSheet.create({
  container: {
    flexGrow: 1,
  },
  gradientContainer: {
    flex: 1,
  }, 

  text1: {
    fontSize: 34,
    color: "white",
    marginBottom: 20,
  },
  text: {
    fontSize: 16,
    color: "white",
    marginBottom: 20,
  },
  searchContainer: {
    flexDirection: "row",
    alignItems: "center",
    marginTop: 120,
    marginLeft: 20,
  },
  searchinput: {
    width: 300,
    height: 40,
    backgroundColor: "white",
    paddingLeft: 20,
    borderRadius: 10,
  },

  suggestionsContainer: {
    position: "absolute",
    top: 150,
    left: 10,
    width: 300,
    backgroundColor: "white",
    borderRadius: 10,
    paddingHorizontal: 10,
    zIndex: 2,
  },
  suggestionItem: {
    paddingVertical: 5,
  },
  suggestionText: {
    fontSize: 16,
  },
  hamburgerIcon: {
    position: "absolute",
    top: 40,
    left: 10,
    zIndex: 1,
  },
  searchicon: {
    marginLeft: 10,
  },
  tinyLogo: {
    width: 30,
    height: 30,
  },
  avatarIcon: {
    position: "absolute",
    top: 40,
    right: 10,
    zIndex: 1,
  },
  locationsContainer: {
    flex: 1,
    marginLeft: 15,
    marginTop:70,
  },
  locationItemContainer: {
    alignItems: "center",
    justifyContent: "center", 
    marginHorizontal: 15, 
    marginBottom: 15, 
    backgroundColor: "rgba(255, 255, 255, 0.2)",
    borderRadius: 10,
    padding: 10,
  },
  locationText: {
    color: "white",
    fontSize: 25,
    textAlign: "center",
    marginTop: 10,
  },
  locationImage: {
    width: 300,
    height: 200,
  },
  text2: {
    fontSize: 30,
    color: "white",
    marginBottom: 30,
  },
});

export default Home;
